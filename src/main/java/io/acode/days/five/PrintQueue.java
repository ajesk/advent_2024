package io.acode.days.five;

import io.acode.util.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PrintQueue {
    private Stream<String> input;
    private final PageMap pageMap = new PageMap();
    private final List<String[]> pageGroups = new ArrayList<>();

    private final IsValid isValid = new IsValid();
    private final FixAndTally fixAndTally = new FixAndTally();

    public PrintQueue(String file) {
        FileReader.readFile(file).forEach(x -> {
            if (x.contains("|")) {
                var split = x.split("\\|");
                pageMap.addPageEdge(split[0], split[1]);
            } else if (x.contains(",")) {
                pageGroups.add(x.split(","));
            }
        });
    }

    public int orderPages() {
        int result = 0;
        for (String[] pageGroup : pageGroups) {
            if (isValid.test(pageGroup, pageMap)) {
                result += Integer.parseInt(pageGroup[(pageGroup.length - 1) / 2]);
            }
        }

        return result;
    }

    public int fixAndCountErrors() {
        int result = 0;
        for (String[] pageGroup : pageGroups) {
           if (!isValid.test(pageGroup, pageMap)) {
               result += fixAndTally.apply(pageGroup, pageMap);
           }
        }

        return result;
    }
}
