package com.company;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchContext {
    private SearchingMethod method;

    public void setMethod(SearchingMethod method) {
        this.method = method;
    }

    public List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String searchString) {
        return this.method.search(list, index, searchString);
    }

}
