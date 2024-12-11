package io.acode.days.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintQueueTest {

    @Test
    void validateTestData() {
        PrintQueue target = new PrintQueue("five/test.txt");

        var result = target.orderPages();
        assertEquals(143, result);
    }

    @Test
    void validateFirstProblem() {
        PrintQueue target = new PrintQueue("five/real.txt");

        var result = target.orderPages();
        assertEquals(4774, result);
    }

    @Test
    void validateTestDataFixAndCountErrors() {
        PrintQueue target = new PrintQueue("five/test.txt");

        var result = target.fixAndCountErrors();
        assertEquals(123, result);
    }

    @Test
    void validateFirstProblemFixAndCountErrors() {
        PrintQueue target = new PrintQueue("five/real.txt");

        var result = target.fixAndCountErrors();
        assertEquals(6004, result);
    }
}
