package io.acode.days.seven;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeRepairTest {
    @Test
    void validateTestData() {
        BridgeRepair target = new BridgeRepair("seven/test.txt");

        var result = target.repairBridge();
        assertEquals(3749, result);
    }

    @Test
    @Disabled
    void validateRealDataRepairBridge() {
        BridgeRepair target = new BridgeRepair("seven/real.txt");

        var result = target.repairBridge();
        assertEquals(0, result);
    }

    @Test
    void validateTestDataPart2() {
        BridgeRepair target = new BridgeRepair("seven/test.txt", true);

        var result = target.repairBridge();
        assertEquals(11387, result);
    }

    @Test
    @Disabled
    void validateRealDataPart2() {
        BridgeRepair target = new BridgeRepair("seven/real.txt", true);

        var result = target.repairBridge();
        assertEquals(0, result);
    }
}
