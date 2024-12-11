package io.acode.days.six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTrackerTest {

    @Test
    void testCloning() {
        MoveTracker old = new MoveTracker(2, 2);
        old.recordMove(new int[]{0, 1}, 2);
        MoveTracker clone = new MoveTracker(old);

        assertArrayEquals(old.moveTrack, clone.moveTrack);
    }

    @Test
    void testCloneDoesNotAffectOriginal() {
        MoveTracker old = new MoveTracker(2, 2);
        MoveTracker clone = new MoveTracker(old);
        clone.recordMove(new int[]{0, 1}, 2);

        assertNotEquals(old.moveTrack[0][1][2], clone.moveTrack[0][1][2]);
    }
}
