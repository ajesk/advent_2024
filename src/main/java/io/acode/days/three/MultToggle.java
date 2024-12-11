package io.acode.days.three;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MultToggle implements Function<String, Stream<String>> {

    @Override
    public Stream<String> apply(String s) {
        List<String> cleanedStrings = new ArrayList<>();
        String[] dontSegments = s.split(Pattern.quote("don't()"));

        cleanedStrings.add(dontSegments[0]);
        for (int i = 1; i < dontSegments.length; i++) {
            var currentSegment = dontSegments[i];
            if (currentSegment.contains("do()")) {
                cleanedStrings.add(currentSegment.substring(currentSegment.indexOf("do()")));
            }
        }

        return cleanedStrings.stream();
    }
}
