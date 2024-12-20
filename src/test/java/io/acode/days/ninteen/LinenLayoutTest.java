package io.acode.days.ninteen;

import io.acode.days.nineteen.LinenLayout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinenLayoutTest {

    @ParameterizedTest
    @CsvSource({
            "brwrr, true",
            "bggr, true",
            "gbbr, true",
            "rrbgbr, true",
            "brwrr, true",
            "ubwu, false",
            "bwurrg, true",
            "brgr, true",
            "bbrgwb, false",
    })
    void testDpPart1(String test, boolean success) {
        LinenLayout target = new LinenLayout("nineteen/test.txt");

        assertEquals(success, target.dp(test, new HashMap<>()));
    }

    @ParameterizedTest
    @CsvSource({
            "nineteen/test.txt, 6",
            "nineteen/real.txt, 0"
    })
    void testPart1(String file, int expected) {
        LinenLayout target = new LinenLayout(file);
        assertEquals(expected, target.countMatches());
    }

    @ParameterizedTest
    @CsvSource({
            "nineteen/test.txt, 16",
            "nineteen/real.txt, 0"
    })
    void testPart2(String file, int expected) {
        LinenLayout target = new LinenLayout(file);
        assertEquals(expected, target.countVariances());
    }
}
