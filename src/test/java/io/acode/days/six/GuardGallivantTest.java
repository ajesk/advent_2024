package io.acode.days.six;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardGallivantTest {

    @Test
    void validateTestData() {
        GuardGallivant target = new GuardGallivant("six/test.txt");

        var result = target.trackGuardLocations();
        assertEquals(41, result);
    }

    @Test
    @Disabled
    void validateFirstProblem() {
        GuardGallivant target = new GuardGallivant("six/real.txt");

        var result = target.trackGuardLocations();
        assertEquals(0, result);
    }

    @Test
    void validateSimulationTestData() {
        GuardGallivant target = new GuardGallivant("six/test.txt");

        var result = target.simulateBlockingGuard();
        assertEquals(6, result);
    }

    @Test
    @Disabled
    void validateFirstProblemFixAndCountErrors() {
        GuardGallivant target = new GuardGallivant("six/real.txt");

        var result = target.simulateBlockingGuard();
        assertEquals(0, result);
    }
}
