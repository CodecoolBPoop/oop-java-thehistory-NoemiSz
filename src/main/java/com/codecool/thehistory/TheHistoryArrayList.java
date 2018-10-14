package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] toArray = text.split("\\s+");
        for (String word : toArray){
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

        wordsArrayList.removeIf(s -> s.equals(wordToBeRemoved));

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information


        for (int i = 0; i < wordsArrayList.size(); i++){
            if (wordsArrayList.get(i).equals(from)){
                wordsArrayList.set(i, to);
            }
        }

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int index = 0;
        List fromW = Arrays.asList(fromWords);
        String toW = Arrays.toString(toWords).replace(",","").replace("[", "").replace("]", "").trim();

            index = Collections.indexOfSubList(wordsArrayList, fromW);


            for (int i = index; i < wordsArrayList.size() - 1; toW.length()) {
                if (index < 0) {
                    break;
                }

                if (index == wordsArrayList.size() - 1) {
                    wordsArrayList.remove(index);
                    wordsArrayList.add(index, toW);
                } else if (fromW.size() == wordsArrayList.size()) {
                    clear();
                    add(toW);
                    break;
                } else {
                    wordsArrayList.subList(index, Math.min(index + fromW.size(), wordsArrayList.size() - 1)).clear();
                    wordsArrayList.add(index, toW);
                }

                index = Collections.indexOfSubList(wordsArrayList, fromW);

            }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
