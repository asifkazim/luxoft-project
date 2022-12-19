package com.luxoft.data;

import java.util.Arrays;

public class Input {

    private char[] vowels;
    private int lengthOfWord;
    private double countVowels;


    public Input(char[] vowels, int lengthOfWord, double countVowels) {
        this.vowels = vowels;
        this.lengthOfWord = lengthOfWord;
        this.countVowels = countVowels;
    }

    public char[] getVowels() {
        return vowels;
    }

    public void setVowels(char[] vowels) {
        this.vowels = vowels;
    }

    public int getLengthOfWord() {
        return lengthOfWord;
    }

    public void setLengthOfWord(int lengthOfWord) {
        this.lengthOfWord = lengthOfWord;
    }

    public double getCountVowels() {
        return countVowels;
    }

    public void setCountVowels(double countVowels) {
        this.countVowels = countVowels;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vowels) + Integer.hashCode(lengthOfWord);
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Input)) {
            return false;
        }

        Input input = (Input) other;
        if (!Arrays.equals(this.vowels, input.vowels)) {
            return false;
        }

        if (this.lengthOfWord != input.lengthOfWord) {
            return false;
        }

        if (this.countVowels != input.countVowels) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "({" + Arrays.toString(vowels) +"}, "
               + lengthOfWord + ") -> " + countVowels + "\n";

    }


}
