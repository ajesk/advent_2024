package io.acode.days.seventeen;

import io.acode.util.FileReader;

public class MyComputer {
    private final String source;

    public MyComputer(String file) {
        source = FileReader.readFile(file).toList().get(4).split(" ")[1];
    }

    long findProgram(long seed) {
        for (int i = 0; i < 1024; i++) {
            long currentTest = i + seed;
            String currentTrial = process(i + seed);
            if (source.equals(currentTrial)) {
                return currentTest;
            } else if (source.endsWith(currentTrial)) {
                var nextTrial = findProgram(currentTest << 3);
                if (nextTrial != -1) {
                    return nextTrial;
                }
            }
        }
        return -1;
    }

    public String process(long seed) {
        long a = seed;
        long b;
        long c;
        StringBuilder out = new StringBuilder();

        do {
            b = a % 8;
            b = b ^ 5;
            c = (long) (a / Math.pow(2, b));
            b = b ^ 6;
            a = (long) (a / Math.pow(2, 3));
            b = b ^ c;
            out.append((out.isEmpty()) ? b % 8 : "," + (b % 8));
        } while (a != 0);

        return out.toString();
    }
}
