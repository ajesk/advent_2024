package io.acode.days.nine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlternateFragmentTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(-1, 1), List.of(1, -1)),
                Arguments.of(List.of(0, -1, -1, 1, 1, 1), List.of(0, -1, -1, 1, 1, 1)),
                Arguments.of(List.of(0, -1, -1, 1, 1), List.of(0, 1, 1, -1, -1)),
                Arguments.of(List.of(0, -1, -1, 1, 1, 1, -1, 2, 2), List.of(0, 2, 2, 1, 1, 1, -1, -1, -1))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void name(List<Integer> test, List<Integer> expected) {
        AlternateFragment fragment = new AlternateFragment();
        assertEquals(expected, fragment.apply(new ArrayList<>(test)));
    }
}
