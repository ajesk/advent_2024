package io.acode.days.eleven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlutonianPebblesTest {

    @Test
    void validatePart1TestData() {
        PlutonianPebbles target = new PlutonianPebbles("eleven/test.txt");

        assertEquals(55312, target.blinkAndCount(25));
    }

    @Test
    void validatePart1RealData() {
        PlutonianPebbles target = new PlutonianPebbles("eleven/real.txt");

        assertEquals(0, target.blinkAndCount(25));
    }

    @Test
    void validatePart2RealData() {
        PlutonianPebbles target = new PlutonianPebbles("eleven/real.txt");

        assertEquals(0, target.blinkAndCount(75));
    }
}
