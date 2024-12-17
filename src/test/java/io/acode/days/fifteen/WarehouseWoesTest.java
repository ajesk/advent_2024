package io.acode.days.fifteen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseWoesTest {

    @ParameterizedTest
    @CsvSource({
            "test.txt, 2028",
            "test2.txt, 10092",
            "real.txt, 0"
    })
    void testPart1(String file, long expected) {
        WarehouseWoes warehouseWoes = new WarehouseWoes("fifteen/" + file);
        warehouseWoes.followInstructions();
        assertEquals(expected, warehouseWoes.getBoxValue());
    }

    @ParameterizedTest
    @CsvSource({
            "test2.txt, 9021",
            "real.txt, 0"
    })
    void testPart2(String file, long expected) {
        WideWarehouseWoes warehouseWoes = new WideWarehouseWoes("fifteen/" + file);
        warehouseWoes.followInstructions();
        assertEquals(expected, warehouseWoes.getBoxValue());
    }
}
