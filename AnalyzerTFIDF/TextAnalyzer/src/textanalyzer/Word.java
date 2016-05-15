/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

/**
 *
 * @author Bryan
 */
public class Word implements Comparable<Word> {
    int count = 1;
        String word = "";

        public Word(String word) {
            this.word = word.toLowerCase();
        }

        public void increment() {
            count += 1;
        }

        public String getWord() {
            return word;
        }

        @Override
        public boolean equals(Object other) {
            Word o = (Word) other;
            if (this.word.equals(o.word)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Word o) {
            return Integer.compare(this.count, o.count);
        }
}
