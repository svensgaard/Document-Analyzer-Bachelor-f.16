/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluation;

import Kmeans.Centroid;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class Result {
    public ArrayList<Centroid> result;
    public long runtime;
    public String method;
    public int iterations;
    public double purity;
    
    public Result(ArrayList<Centroid> result, long runtime, String method, int iterations, double purity) {
        this.result = result;
        this.runtime = runtime;
        this.method = method;
        this.iterations = iterations;
        this.purity = purity;
    }
}
