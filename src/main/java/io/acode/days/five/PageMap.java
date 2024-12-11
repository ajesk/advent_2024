package io.acode.days.five;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PageMap {
    private Map<String, Set<String>> pageOrder = new HashMap<>();

    public void addPageEdge(String start, String end) {
        pageOrder.computeIfAbsent(start, x -> new HashSet<>()).add(end);
    }

    public boolean validOrder(String start, String end) {
        return pageOrder.containsKey(start) && pageOrder.get(start).contains(end);
    }
}
