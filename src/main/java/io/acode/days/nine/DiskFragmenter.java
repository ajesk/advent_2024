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

    public long solvePartTwo() {
        var text = input.findFirst().orElse("");
        int[] filesystem = new int[text.length()];
        for(int i = 0; i < filesystem.length; i++) {
            filesystem[i] = text.charAt(i) - '0';
        }
        long checksum = 0L;

        int[] openStartIndex = new int[filesystem.length];
        openStartIndex[0] = 0;
        for(int i = 1; i < filesystem.length; i++) {
            openStartIndex[i] = openStartIndex[i - 1] + filesystem[i - 1];
        }


        for(int right = filesystem.length - 1; right >= 0; right -= 2) {
            boolean found = false;
            for (int left = 1; left < right; left += 2) {
                if (filesystem[left] >= filesystem[right]) {
                    for (int i = 0; i < filesystem[right]; i++) {
                        checksum += (long) (right / 2) * (openStartIndex[left] + i);
                    }
                    filesystem[left] -= filesystem[right];
                    openStartIndex[left] += filesystem[right];
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < filesystem[right]; i++) {
                    checksum += (long) (right / 2) * (openStartIndex[right] + i);
                }
            }
        }

        return checksum;
    }
}
