package io.acode.days.ten;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoofItTest {

    @Test
    void validatePart1TestData() {
        var result = new HoofIt("ten/test.txt").findTrailHeads();
        assertEquals(36, result);
    }

    @Test
    @Disabled
    void validatePart1RealData() {
        var result = new HoofIt("ten/real.txt").findTrailHeads();
        assertEquals(0, result);
    }

    @Test
    void validatePart2TestData() {
        var result = new HoofIt("ten/test.txt").findTrailRatings();
        assertEquals(81, result);
    }

    @Test
    @Disabled
    void validatePart2RealData() {
        var result = new HoofIt("ten/real.txt").findTrailRatings();
        assertEquals(0, result);
    }
}
