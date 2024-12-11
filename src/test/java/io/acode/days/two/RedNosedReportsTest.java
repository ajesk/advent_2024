package io.acode.days.two;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedNosedReportsTest {
    @Test
    void validatePart1TestData() {
        RedNosedReports target = new RedNosedReports("two/test.txt");

        var result = target.findSafeReports();
        assertEquals(2, result);
    }

    @Test
    @Disabled
    void validatePart1RealData() {
        RedNosedReports target = new RedNosedReports("two/real.txt");

        var result = target.findSafeReports();
        assertEquals(0, result);
    }

    @Test
    void validatePart2TestData() {
        RedNosedReports target = new RedNosedReports("two/test.txt");

        var result = target.findErrorCheckedReports();
        assertEquals(4, result);
    }

    @Test
    @Disabled
    void validatePart2RealData() {
        RedNosedReports target = new RedNosedReports("two/real.txt");

        var result = target.findErrorCheckedReports();
        assertEquals(0, result);
    }
}
