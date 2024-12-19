package io.acode.days.seventeen;

import io.acode.util.FileReader;

import java.util.*;
import java.util.stream.Collectors;

public class ChronospatialComputer {

    private final Map<String, Integer> registers;
    private final List<Integer> instructions;
    private final List<Integer> output = new ArrayList<>();

    public ChronospatialComputer(String file) {
        var lines = FileReader.readFile(file).toList();
        registers = new HashMap<>();
        registers.put("A", Integer.parseInt(lines.get(0).split(" ")[2]));
        registers.put("B", Integer.parseInt(lines.get(1).split(" ")[2]));
        registers.put("C", Integer.parseInt(lines.get(2).split(" ")[2]));

        instructions = Arrays.stream(lines.get(4).split(" ")[1].split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public ChronospatialComputer(int a, int b, int c, String instructionString) {
        instructions = Arrays.stream(instructionString.split(",")).map(Integer::parseInt).toList();
        registers = new HashMap<>();
        registers.put("A", a);
        registers.put("B", b);
        registers.put("C", c);
    }

    public void execute() {
        int pointer = 0;

        while (pointer < instructions.size()) {
            var opcode = instructions.get(pointer);
            var combo = instructions.get(pointer + 1);
            int numerator;
            double denominator;

            switch (opcode) {
                case 0:
                    numerator = registers.get("A");
                    denominator = Math.pow(2, comboValue(combo));
                    registers.put("A", (int) (numerator / denominator));
                    break;
                case 1:
                    registers.put("B", registers.get("B") ^ combo);
                    break;
                case 2:
                    registers.put("B", comboValue(combo) % 8);
                    break;
                case 3:
                    if (registers.get("A") != 0) {
                        pointer = combo - 2;
                    }
                    break;
                case 4:
                    registers.put("B", registers.get("B") ^ registers.get("C"));
                    break;
                case 5:
                    output.add(comboValue(combo) % 8);
                    break;
                case 6:
                    numerator = registers.get("A");
                    denominator = Math.pow(2, comboValue(combo));
                    registers.put("B", (int) (numerator / denominator));
                    break;
                case 7:
                    numerator = registers.get("A");
                    denominator = Math.pow(2, comboValue(combo));
                    registers.put("C", (int) (numerator / denominator));
                    break;
            }

            pointer += 2;
        }
    }

    public String print() {
        return output.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    private int comboValue(int instruction) {
        return switch (instruction) {
            case 0, 1, 2, 3 -> instruction;
            case 4 -> registers.get("A");
            case 5 -> registers.get("B");
            case 6 -> registers.get("C");
            default -> 0;
        };
    }
}
