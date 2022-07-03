package com.company;

import java.util.*;

public class InvertedIndex {
    List<List<String>> list;
    private final Map<String, Set<Integer>> index;

    public InvertedIndex(List<List<String>> list) {
        this.list = list;
        this.index = new HashMap<>();
        initializeIndex();
    }

    private void initializeIndex() {
        for (int i = 0; i < list.size(); i++) {
            for (var element : list.get(i)) {
                if (null != index.putIfAbsent(element.toLowerCase(), new HashSet<>(Set.of(i)))) {
                    Set<Integer> set = new HashSet<>(index.get(element.toLowerCase()));
                    set.add(i);
                    index.put(element.toLowerCase(), set);
                }
            }
        }
    }

    public List<List<String>> search(String keyWord) {
        List<List<String>> searchResults = new ArrayList<>();
        if (index.containsKey(keyWord.toLowerCase())) {
            Set<Integer> indexes = index.get(keyWord.toLowerCase());
            for (var element : indexes) {
                searchResults.add(list.get(element));
            }
        }
        return searchResults;
    }
}
