package io.acode.days.nine;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskFragmenterTest {

    @Test
    void validateTestData() {
        DiskFragmenter target = new DiskFragmenter("nine/test.txt");

        var result = target.part1();
        assertEquals(1928, result);
    }

    @Test
    @Disabled
    void validatePart1() {
        DiskFragmenter target = new DiskFragmenter("nine/real.txt");

        var result = target.part1();
        assertEquals(0, result);
    }

    @Test
    void validatePart2TestData() {
        DiskFragmenter target = new DiskFragmenter("nine/test.txt");

        var result = target.part2();
        assertEquals(2858, result);
    }

    @ParameterizedTest
    @CsvSource({
            "12345, 132",
            "12143, 31",
            "233313312141413140202333133121414131402, 23423",
            "233313312141413140211, 2910",
            "1313165, 169",
            "1909091, 3"

    })
    void validatePart2TestData2(String test, long expected) {
        DiskFragmenter target = new DiskFragmenter(test, false);

        var result = target.part2();
        assertEquals(expected, result);
    }

    @Test
    void validatePart2() {
        DiskFragmenter target = new DiskFragmenter("nine/real.txt");

        var result = target.part2();
        assertEquals(0, result);
    }
}
