package io.acode.days.three;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MullItOverTest {

    @Test
    void validatePart1TestData() {
        MullItOver target = new MullItOver("three/test.txt");

        var result = target.multiplication();
        assertEquals(161, result);
    }

    @Test
    @Disabled
    void validatePart1RealData() {
        MullItOver target = new MullItOver("three/real.txt");

        var result = target.multiplication();
        assertEquals(0, result);
    }

    @ParameterizedTest
    @CsvSource({
            "test.txt, 161",
            "test2.txt, 48"
    })
    void validatePart2TestData2(String file, int expected) {
        MullItOver target = new MullItOver("three/" + file);

        var result = target.startStop();
        assertEquals(expected, result);
    }

    @Test
    @Disabled
    void validateFirstProblemPart2() {
        MullItOver target = new MullItOver("three/real.txt");

        var result = target.startStop();
        assertEquals(0, result);
    }
}
