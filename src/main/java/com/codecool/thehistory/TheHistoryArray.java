package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] toArray = text.split("\\s+");
        wordsArray  =  Arrays.copyOf(toArray, toArray.length);

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        StringBuilder wordsWithout = new StringBuilder();
        for (String word: wordsArray) {
            if (!word.equals(wordToBeRemoved)){
                wordsWithout.append(word).append(" ");
            }
        }
        String wordsWo = wordsWithout.toString();
        add(wordsWo);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information

        for (int i = 0; i < wordsArray.length; i++){
            wordsArray[i]= wordsArray[i].replaceAll(from, to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

        String fromW = Arrays.toString(fromWords).replace(",","").replace("[", "").replace("]", "").trim();
        String toW = Arrays.toString(toWords).replace(",","").replace("[", "").replace("]", "").trim();
        String originalString = Arrays.toString(wordsArray).replace(",","").replace("[", "").replace("]", "").trim();
        originalString = originalString.replaceAll(fromW,toW);
        add(originalString);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
