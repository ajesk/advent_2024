package io.acode.days.four;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeresSearchTest {

    @Test
    void validateTestData() {
        CeresSearch target = new CeresSearch("four/test.txt");

        var result = target.findXmas();
        assertEquals(18, result);
    }

    @Test
    @Disabled
    void validateFirstProblem() {
        CeresSearch target = new CeresSearch("four/real.txt");

        var result = target.findXmas();
        assertEquals(0, result);
    }

    @Test
    void validateTestDataPart2() {
        CeresSearch target = new CeresSearch("four/test.txt");

        var result = target.findMasX();
        assertEquals(9, result);
    }

    @Test
    @Disabled
    void validateFirstProblemPart2() {
        CeresSearch target = new CeresSearch("four/real.txt");

        var result = target.findMasX();
        assertEquals(0, result);
    }
}
