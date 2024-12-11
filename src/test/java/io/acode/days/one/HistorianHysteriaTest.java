package io.acode.days.one;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistorianHysteriaTest {

    @Test
    void validateTestData() {
        HistorianHysteria target = new HistorianHysteria("one/test.txt");

        var result = target.totalDistance();
        assertEquals(11, result);
    }

    @Test
    @Disabled
    void validateFirstProblem() {
        HistorianHysteria target = new HistorianHysteria("one/real.txt");

        var result = target.totalDistance();
        assertEquals(0, result);
    }

    @Test
    void validateTestDataPart2() {
        HistorianHysteria target = new HistorianHysteria("one/test.txt");

        var result = target.similarityScore();
        assertEquals(31, result);
    }

    @Test
    @Disabled
    void validateFirstProblemPart2() {
        HistorianHysteria target = new HistorianHysteria("one/real.txt");

        var result = target.similarityScore();
        assertEquals(0, result);
    }
}
