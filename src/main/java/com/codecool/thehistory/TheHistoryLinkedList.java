package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] toArray = text.split("\\s+");
        for (String word : toArray){
            wordsLinkedList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        Iterator <String> it = wordsLinkedList.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(wordToBeRemoved)) {
                it.remove();
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator <String> it = wordsLinkedList.listIterator();
        while (it.hasNext()){
            if(it.next().equals(from)){
                it.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int index = 0;
        List fromW = Arrays.asList(fromWords);
        String toW = Arrays.toString(toWords).replace(",","").replace("[", "").replace("]", "").trim();

        index = Collections.indexOfSubList(wordsLinkedList, fromW);


        for (int i = index; i < wordsLinkedList.size() - 1; toW.length()) {
            if (index < 0) {
                break;
            }

            if (index == wordsLinkedList.size() - 1) {
                wordsLinkedList.remove(index);
                wordsLinkedList.add(index, toW);
            } else if (fromW.size() == wordsLinkedList.size()) {
                clear();
                add(toW);
                break;
            } else {
                wordsLinkedList.subList(index, Math.min(index + fromW.size(), wordsLinkedList.size())).clear();
                wordsLinkedList.add(index, toW);
            }

            index = Collections.indexOfSubList(wordsLinkedList, fromW);

        }


        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
