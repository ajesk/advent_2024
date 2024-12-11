package io.acode.days.nine;

import io.acode.util.FileReader;

import java.util.stream.Stream;

public class DiskFragmenter {
    private final Stream<String> input;
    private final Expand expand = new Expand();
    private final Fragment fragment = new Fragment();
    private final AlternateFragment alternateFragment = new AlternateFragment();
    private final CheckSum checkSum = new CheckSum();

    public DiskFragmenter(String file) {
        input = FileReader.readFile(file);
    }

    public DiskFragmenter(String text, boolean ignored) {
        input = Stream.of(text);
    }

    public long part1() {
        return input.map(expand)
                .map(fragment)
                .mapToLong(checkSum).sum();
    }

    public long part2() {
        return input.map(expand)
                .map(alternateFragment)
                .mapToLong(checkSum).sum();
    }
}
