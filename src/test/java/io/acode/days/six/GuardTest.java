package io.acode.days.six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuardTest {

    @Test
    void testBaseCloneIsEqual() {
        Guard old = new Guard(new int[]{0, 1});
        Guard clone = new Guard(old);

        assertArrayEquals(old.getPosition(), clone.getPosition());
        assertArrayEquals(old.getNextPosition(), clone.getNextPosition());
        assertEquals(old.getDirection(), clone.getDirection());
    }

    @Test
    void testOldDoesNotManipulateClone() {
        Guard old = new Guard(new int[]{0, 1});
        Guard clone = new Guard(old);

        old.performMove();
        old.rotate();
        assertNotEquals(old.getPosition()[0], clone.getPosition()[0]);
        assertNotEquals(old.getDirection(), clone.getDirection());
    }

    @Test
    void testCloneDoesNotManipulateClone() {
        Guard old = new Guard(new int[]{0, 1});
        Guard clone = new Guard(old);

        clone.performMove();
        clone.rotate();
        assertNotEquals(old.getPosition()[0], clone.getPosition()[0]);
        assertNotEquals(old.getDirection(), clone.getDirection());
    }
}
