package io.acode.days.sixteen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReindeerMazeTest {
    @ParameterizedTest
    @CsvSource({
            "test.txt, 7036",
            "test2.txt.txt, 11048",
            "real.txt, 0"
    })
    void testPart1(String file, int expected) {
        ReindeerMaze maze = new ReindeerMaze("sixteen/" + file);

        assertEquals(expected, maze.findShortestPath());
    }

    @ParameterizedTest
    @CsvSource({
            "test.txt, 42",
            "test2.txt.txt, 64",
            "real.txt, 0"
    })
    void testPart2(String file, int expected) {
        ReindeerMaze maze = new ReindeerMaze("sixteen/" + file);

        assertEquals(expected, maze.findBestSpots());
    }
}
