package com.company;

import java.util.*;

public class AllSearchingMethod  implements SearchingMethod{


    @Override
    public List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String searchString) {
        List<List<String>> searchResults = new ArrayList<>();
        String[] words = searchString.toLowerCase().split("\\s");
        List<Set<Integer>> matchingIndexes = new ArrayList<>();
        for (String word : words) {
            if (index.containsKey(word)) {
                matchingIndexes.add(index.get(word));
            }
        }
        for (int i = 1; i < matchingIndexes.size(); i++) {
            matchingIndexes.get(0).retainAll(matchingIndexes.get(i));
        }

        if (!matchingIndexes.isEmpty()) {
            for (int indexOfPerson : matchingIndexes.get(0)) {
                searchResults.add(list.get(indexOfPerson));
            }
        }
        return searchResults;
    }
}
