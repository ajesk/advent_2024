package io.acode.days.six;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GuardMapTest {
    @Test
    void testClone() {
        List<List<Character>> grid = List.of(List.of('.'));
        GuardMap guardMap = new GuardMap(grid);
        GuardMap clone = new GuardMap(guardMap);

        clone.setRock(new int[]{0,0});

    }
}
