/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans;

import Evaluation.EvaluationWrapper;
import analyzertfidf.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Mads
 */
public class Clustering {

    public int globalCounter = 0;
    public int publicCounter;
    private final SimilarityMatrics simMatrics = new SimilarityMatrics();
    private final EvaluationWrapper evaluation = new EvaluationWrapper();
    private int MAX_ITERATIONS = 50;
    private double MIN_SIMILARITY = 0.6;
    private double currentSimilarity = 0;

    public void setParameters(int max_iterations, double min_similarity) {
        MAX_ITERATIONS = max_iterations;
        MIN_SIMILARITY = min_similarity;
    }
    
    public void setMinSimilarity(double min) {
        MIN_SIMILARITY = min;
    }

//k is number of clusters.
    public ArrayList<Centroid> prepareCluster(int k, ArrayList<Text> texts, boolean betterStart) {
        long start = System.currentTimeMillis();
        globalCounter = 0;
        ArrayList<Centroid> centroids;

        Boolean stop;
        ArrayList<Centroid> result;
        ArrayList<Centroid> previousClusterCenter;
        centroids = initialize(texts, k, betterStart);
        result = InitializeClusterCentroid(centroids.size());
        do { //Continue until stop criteria are met.
            previousClusterCenter = centroids;

            for (Text t : texts) {
                int i = FindClosestClusterCenter(centroids, t);
                result.get(i).GroupedDocument.add(t);
            }
            centroids = CalculateMeanPoints(result);
            stop = CheckStop(previousClusterCenter, centroids);
            if (!stop) {
                result = InitializeClusterCentroid(centroids.size());
            }
            currentSimilarity = evaluation.getAvgSimilarity(result);
            if (currentSimilarity < MIN_SIMILARITY) {
                if (globalCounter < MAX_ITERATIONS) {
                    stop = false;
                    centroids = initialize(texts, k, betterStart);
                    result = InitializeClusterCentroid(centroids.size());
                }

            }
        } while (stop == false);

        long end = System.currentTimeMillis();
        System.out.println("Clustering running time: " + (end - start) + "ms");

        int i = 1;
        for (Centroid c : result) {
            c.name = "Centroid" + i;
            i++;
        }

        return result;

    }

    public ArrayList<Centroid> prepareClusterIncrement(ArrayList<Text> texts, boolean betterStart) {
        long start = System.currentTimeMillis();
        System.out.println("TOTAL TEXTS: " + texts.size() + "\n");
        int totalCentroids = 1;
        ArrayList<Centroid> result;

        do {
            result = prepareCluster(totalCentroids, texts, betterStart);
            System.out.println("Total centroids: " + totalCentroids
                    + "Minimum similarity: " + MIN_SIMILARITY
                    + "Current Similarity: " + currentSimilarity + "\n");
            if (currentSimilarity < MIN_SIMILARITY) {
                totalCentroids++;
            }
        } while (currentSimilarity < MIN_SIMILARITY);
        System.out.println("CLUSTERING DONE\n"
                + "RESULT:\n"
                + "Total centroids: " + totalCentroids
                + "\tMinimum similarity: " + MIN_SIMILARITY
                + "\tCurrent Similarity: " + currentSimilarity + "\n");
        return result;
    }

    private ArrayList<Centroid> InitializeClusterCentroid(int size) {
        Centroid c;
        ArrayList<Centroid> centroid = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            c = new Centroid();
            c.GroupedDocument = new ArrayList<>();
            centroid.add(c);
        }
        return centroid;

    }

    // force commit
    public int FindClosestClusterCenter(ArrayList<Centroid> centroids, Text t) {
        SimilarityMatrics similarityMatrics = new SimilarityMatrics();
        Double[] similarities = new Double[centroids.size()];
        for (int i = 0; i < centroids.size(); i++) {
//            tfdif[i] = similarityMatrics.findCosineSimilarity(centroids.get(i).GroupedDocument.get(0).getVectorSpace(), t.getVectorSpace());
            similarities[i] = similarityMatrics.findCosineSimilarity(centroids.get(i).getAverageVector(), t.getVectorSpace()); //BEST RESULTS
        }
        //Evaluate the maximum 
        int index = 0;
        Double maxFound = similarities[0];
        for (int i = 0; i < similarities.length; i++) {
            if (similarities[i] < maxFound) {
                maxFound = similarities[i];
                index = i;
            }
        }
        return index;
    }

    private ArrayList<Centroid> CalculateMeanPoints(ArrayList<Centroid> result) {
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).GroupedDocument.size() > 0) {
//                for (int k = 0; k < result.get(i).GroupedDocument.get(0).getVectorSpace().length; k++) {
                for (int k = 0; k < result.get(i).getAverageVector().length; k++) {
                    Double total = 0.0;

                    for (Text t : result.get(i).GroupedDocument) {
                        total += t.getVectorSpace()[k];
                    }
//                    result.get(i).GroupedDocument.get(0).getVectorSpace()[k] = total / result.get(i).GroupedDocument.size();
                    result.get(i).getAverageVector()[k] = total / result.get(i).GroupedDocument.size();

                }
            }
        }
        return result;
    }

    private Boolean CheckStop(ArrayList<Centroid> previousClusterCenter, ArrayList<Centroid> centroids) {
        globalCounter++;
        Boolean stop = false;
        if (globalCounter > MAX_ITERATIONS) {
            return true;
        } else {

            Integer[] changeIndex = new Integer[centroids.size()];
            int index = 0;

            do {
                if (centroids.get(index).GroupedDocument.isEmpty() && previousClusterCenter.get(index).GroupedDocument.isEmpty()) {
                    index++;
                    System.out.println("INDEX: " + index);
                    System.out.println("CHANGEINDEX LENGHT: " + changeIndex.length);
                    changeIndex[index] = 0;
                } else if (!centroids.get(index).GroupedDocument.isEmpty() && !previousClusterCenter.get(index).GroupedDocument.isEmpty()) {
                    for (int k = 0; k < centroids.get(index).getAverageVector().length; k++) {
//                        if (centroids.get(index).GroupedDocument.get(0).getVectorSpace()[k].equals(previousClusterCenter.get(index).GroupedDocument.get(0).getVectorSpace()[k])) {
                        if (!centroids.get(index).getAverageVector()[k].equals(previousClusterCenter.get(index).getAverageVector()[k])) { //Change back to document[0].getvectorspace if bad results.
//                            changeIndex[index] = 1;
                            return true;
                        } else {
                            changeIndex[index] = 0;
                        }
                    }
//                    if (count == centroids.get(index).GroupedDocument.get(0).getVectorSpace().length) {
//                    if (count == centroids.get(index).getAverageVector().length) {
//                        changeIndex[index] = 0;
//                    } else {
//                        changeIndex[index] = 1;
//                    }
                    index++;
                } else {
                    changeIndex[index] = 1;
                    index++;
                }

            } while (index < centroids.size());
//            If any index contains 1
            for (int i : changeIndex) {
                System.out.println("i: " + i);
                if (i == 1) {
                    stop = true;
                }
            }
        }

        return stop;
    }

    //Choose better inital centroids
    private ArrayList<Text> chooseInitialCenters(ArrayList<Text> texts, int k) {

        // Convert to list for indexed access. Make it unmodifiable, since removal of items
        // would screw up the logic of this method.
        final ArrayList<Text> pointList = texts;

        // The number of points in the list.
        final int numPoints = pointList.size();

        // Set the corresponding element in this array to indicate when
        // elements of pointList are no longer available.
        final boolean[] taken = new boolean[numPoints];

        // The resulting list of initial centers.
        final ArrayList<Text> resultSet = new ArrayList<>();
        Random random = new Random();
        // Choose one center uniformly at random from among the data points.
        final int firstPointIndex = random.nextInt(numPoints);

        final Text firstPoint = pointList.get(firstPointIndex);

        resultSet.add(firstPoint);

        // Must mark it as taken
        taken[firstPointIndex] = true;

        // To keep track of the minimum distance squared of elements of
        // pointList to elements of resultSet.
        final double[] minDistSquared = new double[numPoints];

        // Initialize the elements.  Since the only point in resultSet is firstPoint,
        // this is very easy.
        for (int i = 0; i < numPoints; i++) {
            if (i != firstPointIndex) { // That point isn't considered
//                double d = firstPoint.distanceFrom(pointList.get(i));
                double d = simMatrics.findCosineSimilarity(firstPoint.getVectorSpace(), pointList.get(i).getVectorSpace());
                minDistSquared[i] = d * 2;
            }
        }

        while (resultSet.size() < k) {

            // Sum up the squared distances for the points in pointList not
            // already taken.
            double distSqSum = 0.0;

            for (int i = 0; i < numPoints; i++) {
                if (!taken[i]) {
                    distSqSum += minDistSquared[i];
                }
            }

            // Add one new data point as a center. Each point x is chosen with
            // probability proportional to D(x)2
            final double r = random.nextDouble() * distSqSum;

            // The index of the next point to be added to the resultSet.
            int nextPointIndex = -1;

            // Sum through the squared min distances again, stopping when
            // sum >= r.
            double sum = 0.0;
            for (int i = 0; i < numPoints; i++) {
                if (!taken[i]) {
                    sum += minDistSquared[i];
                    if (sum >= r) {
                        nextPointIndex = i;
                        break;
                    }
                }
            }

            // If it's not set to >= 0, the point wasn't found in the previous
            // for loop, probably because distances are extremely small.  Just pick
            // the last available point.
            if (nextPointIndex == -1) {
                for (int i = numPoints - 1; i >= 0; i--) {
                    if (!taken[i]) {
                        nextPointIndex = i;
                        break;
                    }
                }
            }

            // We found one.
            if (nextPointIndex >= 0) {

                final Text p = pointList.get(nextPointIndex);

                resultSet.add(p);

                // Mark it as taken.
                taken[nextPointIndex] = true;

                if (resultSet.size() < k) {
                    // Now update elements of minDistSquared.  We only have to compute
                    // the distance to the new center to do this.
                    for (int j = 0; j < numPoints; j++) {
                        // Only have to worry about the points still not taken.
                        if (!taken[j]) {
//                            double d = p.distanceFrom(pointList.get(j));
                            double d = simMatrics.findCosineSimilarity(p.getVectorSpace(), pointList.get(j).getVectorSpace());
                            double d2 = d * d;
                            if (d2 < minDistSquared[j]) {
                                minDistSquared[j] = d2;
                            }
                        }
                    }
                }

            } else {
                // None found --
                // Break from the while loop to prevent
                // an infinite loop.
                break;
            }
        }

        return resultSet;
    }

    private ArrayList<Centroid> initialize(ArrayList<Text> texts, int k, boolean betterStart) {
        Centroid x;
        ArrayList<Centroid> centroids = new ArrayList<>();
        if (betterStart) {
            //Use chooseinitialCenters method which is not just random
            for (Text t : chooseInitialCenters(texts, k)) {
                x = new Centroid();
                x.GroupedDocument = new ArrayList<>();
                x.GroupedDocument.add(t);
                centroids.add(x);

            }
        } else {
            //Choose 3 centroids at random
            HashSet<Integer> uniqNumber = generateRandomNumbers(k, texts.size());
            for (Integer i : uniqNumber) {
                x = new Centroid();
                x.GroupedDocument = new ArrayList<>();
                x.GroupedDocument.add(texts.get(i));
                centroids.add(x);
            }
        }
        return centroids;
    }

    private HashSet<Integer> generateRandomNumbers(int k, int size) {
        HashSet<Integer> uniqRandom = new HashSet<>();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);
        for (int i = 0; i < k; i++) {
            uniqRandom.add(randomNumbers.get(i));
        }

        return uniqRandom;
    }

}
