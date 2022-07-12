package com.company;

import java.util.*;

public class AnySearchingMethod implements SearchingMethod{
    @Override
    public List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String keyWord) {
        List<List<String>> searchResults = new ArrayList<>();
        String[] words = keyWord.toLowerCase().split("\\s");
        Set<Integer> matchingIndexes = new HashSet<>();
        for (String word : words) {
            if (index.containsKey(word)) {
                matchingIndexes.addAll(index.get(word));
            }
        }
        for (int matchingIndex : matchingIndexes) {
            searchResults.add(list.get(matchingIndex));
        }
        return searchResults;
    }
}
