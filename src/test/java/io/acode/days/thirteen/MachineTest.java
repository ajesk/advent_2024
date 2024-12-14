package io.acode.days.thirteen;

import io.acode.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachineTest {
    @ParameterizedTest
    @CsvSource({
            "94, 34, 22, 67, 8400, 5400, 280"
    })
    void testExampleMachine(int ax, int ay, int bx, int by, int px, int py, int tokens) {
        var result = new Machine(new Pair(ay, ax), new Pair(by, bx), new Pair(py, px)).calculate(0);

        assertEquals(tokens, result);
    }
}
