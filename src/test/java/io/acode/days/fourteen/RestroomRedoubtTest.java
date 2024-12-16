package io.acode.days.fourteen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestroomRedoubtTest {


    @ParameterizedTest
    @CsvSource({
            "fourteen/test.txt, 7, 11, 12",
            "fourteen/real.txt, 103, 101, 0",
    })
    void part1(String file, int height, int width, int expected) {
        RestroomRedoubt target = new RestroomRedoubt(file, height, width);

        assertEquals(expected, target.calculateQuadrants(100));
    }

    @ParameterizedTest
    @CsvSource({
            "fourteen/real.txt, 103, 101, 0",
    })
    void part1(String file, int height, int width) {
        RestroomRedoubt target = new RestroomRedoubt(file, height, width);

        target.findTree(10000);
    }
}
