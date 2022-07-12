package com.company;

import java.util.*;

public class NoneSearchingMethod implements SearchingMethod{


    @Override
    public List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String keyWord) {
        List<List<String>> searchResults = new ArrayList<>();
        String[] words = keyWord.toLowerCase().split("\\s");
        Set<Integer> matchingIndexes = new HashSet<>();
        for (var element : index.entrySet()) {
            for (String word : words) {
                if (word.equals(element.getKey())) {
                    matchingIndexes.addAll(element.getValue());
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!matchingIndexes.contains(i)) {
                searchResults.add(list.get(i));
            }
        }
        return searchResults;
    }
}
