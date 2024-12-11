package io.acode.days.two;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsASafeReportTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2",
            "1, 2, 3",
            "3, 2, 1",
            "7, 6, 4, 2, 1",
            "1, 3, 6, 7, 9",
    })
    void positiveScenarios(@ConvertWith(CSVtoArray.class) List<Integer> test) {
        IsASafeReport target = new IsASafeReport();
        assertTrue(target.test(test));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 7, 8, 9",
            "9, 7, 6, 2, 1",
            "1, 3, 2, 4, 5",
            "8, 6, 4, 4, 1",
    })
    void negativeScenarios(@ConvertWith(CSVtoArray.class) List<Integer> test) {
        IsASafeReport target = new IsASafeReport();
        assertFalse(target.test(test));
    }
    public static class CSVtoArray extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            String s = (String) source;
            ConvertToNumList numList = new ConvertToNumList();
            return numList.apply(s.replace(",", ""));
        }
    }
}
