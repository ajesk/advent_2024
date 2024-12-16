package io.acode.days.fourteen;

import io.acode.util.Pair;

import java.util.List;

public class Robot {
    private final Pair start;
    private final Pair move;
    private final Pair bounds;

    public Robot(Pair start, Pair move, Pair bounds) {
        this.start = start;
        this.move = move;
        this.bounds = bounds;
    }

    public Robot(List<Integer> values, int height, int width) {
        this(
                new Pair(values.get(1), values.get(0)),
                new Pair(values.get(3), values.get(2)),
                new Pair(height, width));
    }

    public Pair calculateMove(int num) {
        int newY = (start.y() + (move.y() * num)) % bounds.y();
        if (newY < 0) newY = newY + bounds.y();
        int newX = (start.x() + (move.x() * num)) % bounds.x();
        if (newX < 0) newX = newX + bounds.x();
        return new Pair(newY, newX);
    }
}
