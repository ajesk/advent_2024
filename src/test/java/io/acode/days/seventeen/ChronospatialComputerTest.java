package io.acode.days.seventeen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChronospatialComputerTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 9, '2,6', ''",
            "0, 29, 9, '1,7', ''",
            "10, 0, 0, '5,0,5,1,5,4', '0,1,2'",
            "2024, 0, 0, '0,1,5,4,3,0', '4,2,5,6,7,7,7,7,3,1,0'",
    })
    void validatePart1Scenarios(int a, int b, int c, String instruction, String expected) {
        ChronospatialComputer computer = new ChronospatialComputer(a, b, c, instruction);
        computer.execute();
        assertEquals(expected, computer.print());
    }

    @ParameterizedTest
    @CsvSource({
            "test.txt, '4,6,3,5,6,3,5,2,1,0'",
            "real.txt, ''",
    })
    void validatePart1Scenarios(String file, String expected) {
        ChronospatialComputer computer = new ChronospatialComputer("seventeen/" + file);
        computer.execute();
        assertEquals(expected, computer.print());
    }

    @Test
    void validatePart2Scenarios() {
        for (int i = 0; i < 2056; i++) {


            ChronospatialComputer computer = new ChronospatialComputer(i, 0, 0, "2,4,1,5,7,5,1,6,0,3,4,6,5,5,3,0");
            computer.execute();
            System.out.println(i + ": " + computer.print());
        }
    }
}
