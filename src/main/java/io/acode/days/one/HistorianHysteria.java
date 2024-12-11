package io.acode.days.one;

import io.acode.util.FileReader;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class HistorianHysteria {
    private final Stream<String> input;

    public HistorianHysteria(String file) {
        input = FileReader.readFile(file);
    }

    public int similarityScore() {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        input.map(x -> x.trim().replaceAll(" +", " "))
                .forEach(x -> {
                    final var vals = x.split(" ");
                    m1.merge(vals[0], 1, Integer::sum);
                    m2.merge(vals[1], 1, Integer::sum);
                });
        return crossReference(m1, m2);
    }

    private int crossReference(Map<String, Integer> m1, Map<String, Integer> m2) {
        return m1.entrySet()
                .stream()
                .mapToInt(entry -> entry.getValue() * Integer.parseInt(entry.getKey()) * m2.getOrDefault(entry.getKey(), 0))
                .sum();
    }

    // Part 1
    public int totalDistance() {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        input.map(x -> x.trim().replaceAll(" +", " "))
                .forEach(x -> {
                    final var vals = x.split(" ");
                    pq1.add(Integer.valueOf(vals[0]));
                    pq2.add(Integer.valueOf(vals[1]));
                });
        return popAndCount(pq1, pq2);
    }

    private int popAndCount(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        int totalDistance = 0;

        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            totalDistance += Math.abs(pq1.poll() - pq2.poll());
        }
        return totalDistance;
    }

}
