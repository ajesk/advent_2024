package io.acode.days.twelve;

import io.acode.days.eleven.PlutonianPebbles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GardenGroupsTest {

    @Test
    void validatePart1TestData() {
        GardenGroups target = new GardenGroups("twelve/test.txt");

        assertEquals(1930, target.getGroupCounts());
    }

    @Test
    void validatePart1RealData() {
        GardenGroups target = new GardenGroups("twelve/real.txt");

        assertEquals(0, target.getGroupCounts());
    }

    @Test
    void validatePart2RealData() {
        PlutonianPebbles target = new PlutonianPebbles("eleven/real.txt");

        assertEquals(0, target.blinkAndCount(75));
    }
}
