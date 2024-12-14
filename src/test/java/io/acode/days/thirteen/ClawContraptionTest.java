package io.acode.days.thirteen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClawContraptionTest {
    @ParameterizedTest
    @CsvSource({
            "thirteen/test.txt, 480",
            "thirteen/real.txt, 0"
    })
    void testPartOneInputs(String file, long expected) {
        long result = new ClawContraption(file).calculatePrizes();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "thirteen/test.txt, 480",
            "thirteen/real.txt, 0"
    })
    void testPartTwoInputs(String file, long expected) {
        long result = new ClawContraption(file).calculatePrizes(10000000000000L);
        assertEquals(expected, result);
    }
}
