package io.acode.days.three;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExtractMul implements Function<String, Stream<String>> {

    @Override
    public Stream<String> apply(String s) {
        final var pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        final var matcher = pattern.matcher(s);
        List<String> results = new ArrayList<>();

        while(matcher.find()) {
            results.add(matcher.group());
        }
        return results.stream();
    }
}
