package io.acode.days.six;

public class GuardSimulator {
    MoveTracker moveTracker;
    GuardMap guardMap;
    Guard guard;
    boolean[][] rocks;

    public GuardSimulator(MoveTracker moveTracker, GuardMap guardMap, Guard guard, boolean[][] rocks) {
        this.moveTracker = new MoveTracker(moveTracker);
        this.guardMap = new GuardMap(guardMap);
        this.guard = new Guard(guard);
        this.rocks = rocks;
    }

    public boolean runSimulation() {
        guardMap.setRock(guard.getNextPosition());
        if (guardMap.positionValid(guard.getNextPosition()) &&
                !rocks[guard.getNextPosition()[0]][guard.getNextPosition()[1]]) {
            rocks[guard.getNextPosition()[0]][guard.getNextPosition()[1]] = true;
        } else {
            return false;
        }
        moveTracker.recordMove(guard.getPosition(), guard.getDirection());

        while (guardMap.positionValid(guard.getPosition())) {
            if (guardMap.isRockAt(guard.getNextPosition())) {
                guard.rotate();
            } else {
                guard.performMove();
            }

            if (moveTracker.recordMove(guard.getPosition(), guard.getDirection())) {
                return true;
            }
        }
        return false;
    }
}
