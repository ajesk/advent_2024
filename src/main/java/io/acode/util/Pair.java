package io.acode.util;

public record Pair(int y, int x) {

    public Pair(Pair p1, Pair p2) {
        this(p1.y() + p2.y(), p1.x() + p2.x());
    }
}
