package io.acode.days.two;

import io.acode.util.FileReader;

import java.util.stream.Stream;

public class RedNosedReports {
    private final Stream<String> input;
    private final ConvertToNumList convert = new ConvertToNumList();
    private final IsASafeReport isASafeReport = new IsASafeReport();
    private final IsASafeErrorCheckedReport isASafeErrorCheckedReport = new IsASafeErrorCheckedReport();

    public RedNosedReports(String file) {
        input = FileReader.readFile(file);
    }

    public int findSafeReports() {
        return (int) input.map(convert)
                .filter(isASafeReport)
                .count();
    }

    public int findErrorCheckedReports() {
        return (int) input.map(convert)
                .filter(isASafeErrorCheckedReport)
                .count();
    }
}
