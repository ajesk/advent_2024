package io.acode.days.three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractMulTest {


    @ParameterizedTest
    @CsvSource({
            "'mul(1,3)', 1",
            "'xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))', 4",
            "'mul(4*', 0",
            "'mul(6,9!', 0",
            "'?(12,34)', 0",
            "'mul ( 2 , 4 )', 0",
            "'mul(2,4 )', 0",
            "'mul(2, 4)', 0",
            "'mul(2 ,4)', 0",
            "'mul( 2,4)', 0",
            "'mul (2,4)', 0",
    })
    void testExtractions(String test, int count) {
        final ExtractMul function = new ExtractMul();

        final var res = function.apply(test);

        assertEquals(count, res.toList().size());
    }


}
