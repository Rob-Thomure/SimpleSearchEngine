package com.company;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchingMethod {

    List<List<String>> search(List<List<String>> list, Map<String, Set<Integer>> index, String keyWord);


}
