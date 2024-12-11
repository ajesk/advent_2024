package io.acode.days.three;

import io.acode.util.FileReader;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MullItOver {

    Stream<String> input;
    ExtractMul extractMul = new ExtractMul();
    ExecuteMul executeMul = new ExecuteMul();
    MultToggle multToggle = new MultToggle();

    public MullItOver(String file) {
        input = FileReader.readFile(file);
    }

    public int multiplication() {
        return input
                .flatMap(extractMul)
                .mapToInt(executeMul)
                .sum();
    }

    public int startStop() {
        return Stream.of(input.collect(Collectors.joining(";")))
                .flatMap(multToggle)
                .flatMap(extractMul)
                .mapToInt(executeMul)
                .sum();
    }
}
