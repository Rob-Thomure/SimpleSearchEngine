package com.company;

import java.util.*;

public class AllSearchingMethod  implements SearchingMethod{


    @Override
    public List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String searchString) {
        List<List<String>> searchResults = new ArrayList<>();
        String[] words = searchString.toLowerCase().split("\\s");
        Map<String, Set<Integer>> namesMatching = new HashMap<>();
        List<Set<Integer>> matchingIndexes = new ArrayList<>();
        for (String word : words) {
            if (index.containsKey(word)) {
                matchingIndexes.add(index.get(word));
            }
        }
        // TODO do a retain all on the list of sets






        if (index.containsKey(searchString.toLowerCase())) {
            Set<Integer> indexes = index.get(searchString.toLowerCase());
            for (var element : indexes) {
                searchResults.add(list.get(element));
            }
        }


        return searchResults;
    }
}
