package io.acode.days.five;

import java.util.function.BiFunction;

public class FixAndTally implements BiFunction<String[], PageMap, Integer> {
    @Override
    public Integer apply(String[] pages, PageMap pageMap) {
        for (int i = 0; i < pages.length; i++) {
            for (int j = i + 1; j < pages.length; j++) {
                if (pageMap.validOrder(pages[j], pages[i])) {
                    String hold = pages[i];
                    pages[i] = pages[j];
                    pages[j] = hold;
                    return apply(pages, pageMap);
                }
            }
        }
        return Integer.parseInt(pages[(pages.length - 1) / 2]);
    }

}
