package io.acode.days.six;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MoveTracker {
    boolean[][][] moveTrack;

    public MoveTracker(int height, int width) {
        this.moveTrack = new boolean[height][width][4];
    }

    public MoveTracker(MoveTracker previous) {
        moveTrack = previous.cloneArray();

//        this.moveTrack = new boolean[track.length][track[0].length][4];
//        for (int k = 0; k < track.length; k++) {
//            boolean[][] rows  track[k];
//            for (int j = 0; j < rows.length; j++) {
//                boolean[] cell = rows[j];
//                System.arraycopy(cell, 0, moveTrack[k][j], 0, cell.length);
//            }
//        }
    }

    public boolean recordMove(int[] position, int direction) {
        if (!(position[0] >= 0 && position[0] < moveTrack.length &&
                position[1] >= 0 && position[1] < moveTrack[0].length)) {
            return false;
        }

        if (!moveTrack[position[0]][position[1]][direction]) {
            moveTrack[position[0]][position[1]][direction] = true;
            return false;
        }
        return true;
    }

    public boolean[][][] cloneArray() {
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            new ObjectOutputStream(out).writeObject(moveTrack);
            return (boolean[][][])
                    new ObjectInputStream(new ByteArrayInputStream(out.toByteArray())).readObject();
        } catch (Exception e) {
            return new boolean[][][]{};
        }
    }
}
