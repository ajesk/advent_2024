package io.acode.days.four;

import io.acode.util.FileReader;

import java.util.stream.Stream;

public class CeresSearch {
    private final Stream<String> input;
    private final SearchFromSpace searchFromSpace = new SearchFromSpace();
    private final IsAMasX isAMasX = new IsAMasX();

    public CeresSearch(String file) {
        input = FileReader.readFile(file);
    }

    public int findXmas() {
        int i = 0;
        var inputList = input.toList();
        final char[][] characterGrid = new char[inputList.size()][inputList.getFirst().length()];
        int result = 0;

        for (String line : inputList) {
            char[] lineChar = line.toCharArray();
            characterGrid[i] = lineChar;
            i++;
        }

        for (int y = 0; y < characterGrid.length; y++) {
            for (int x = 0; x < characterGrid[0].length; x++) {
                result += searchFromSpace.apply(new int[]{y, x}, characterGrid);
            }
        }

        return result;
    }

    public int findMasX() {
        int i = 0;
        var inputList = input.toList();
        final char[][] characterGrid = new char[inputList.size()][inputList.getFirst().length()];
        int result = 0;

        for (String line : inputList) {
            char[] lineChar = line.toCharArray();
            characterGrid[i] = lineChar;
            i++;
        }

        for (int y = 1; y < characterGrid.length - 1; y++) {
            for (int x = 1; x < characterGrid[0].length - 1; x++) {
                result += isAMasX.test(new int[]{y, x}, characterGrid) ? 1 : 0;
            }
        }
        return result;
    }

}
