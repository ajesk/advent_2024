package io.acode.days.three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MultToggleTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))",
    })
    void testExtractions(String test) {
        final MultToggle function = new MultToggle();

        final var res = function.apply(test);

        assertNotNull(res);
    }


}
