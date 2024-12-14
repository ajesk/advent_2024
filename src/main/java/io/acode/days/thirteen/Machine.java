package io.acode.days.thirteen;

import io.acode.util.Pair;

public class Machine {
    private final Pair buttonA;
    private final Pair buttonB;
    private final Pair prize;

    public Machine(Pair buttonA, Pair buttonB, Pair prize) {
        this.buttonA = buttonA;
        this.buttonB = buttonB;
        this.prize = prize;
    }

    public long calculate(long offset) {
        long prizeX = prize.x() + offset;
        long prizeY = prize.y() + offset;
        int dem = buttonA.x() * buttonB.y() - buttonA.y() * buttonB.x();
        double aPresses = (double) (prizeX * buttonB.y() - prizeY * buttonB.x()) / dem;
        double bPresses = (double) (prizeY * buttonA.x() - prizeX * buttonA.y()) / dem;

        if (aPresses % 1 == 0) {
            return (long) (aPresses * 3 + bPresses);
        } else {
            return 0;
        }
    }
}