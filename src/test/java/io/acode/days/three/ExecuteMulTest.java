package io.acode.days.three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuteMulTest {


    @ParameterizedTest
    @CsvSource({
            "'mul(1,3)', 3",
            "'mul(10,10)', 100",
            "'mul(0,3)', 0",
            "'mul(2,0)', 0",
    })
    void testExtractions(String test, int expected) {
        final ExecuteMul function = new ExecuteMul();

        final var res = function.applyAsInt(test);

        assertEquals(expected, res);
    }


}
