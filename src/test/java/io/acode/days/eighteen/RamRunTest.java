package io.acode.days.eighteen;

import io.acode.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RamRunTest {

    @ParameterizedTest
    @CsvSource({
            "eighteen/test.txt, 7, 12, 22",
            "eighteen/real.txt, 71, 1024, 0"
    })
    void testPart1(String file, int size, int bytes, int expected) {
        RamRun ramRun = new RamRun(file, size, bytes);
        assertEquals(expected, ramRun.run());
    }

    @ParameterizedTest
    @CsvSource({
            "eighteen/test.txt, 7, 6, 1",
            "eighteen/real.txt, 71, 0, 0"
    })
    void testPart2(String file, int size, int ey, int ex) {
        RamRun ramRun = new RamRun(file, size);
        assertEquals(new Pair(ey, ex), ramRun.calculateLastFlake());
    }
}
