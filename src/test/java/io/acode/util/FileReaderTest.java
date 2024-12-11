package io.acode.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    @Test
    void validateTestFileContainsLines() {
        final var testFile = "test.txt";

        final var res = FileReader.readFile(testFile).toList();

        assertFalse(res.isEmpty());
        assertEquals(1, res.size());
        assertEquals("hello, world", res.getFirst());
    }

    @Test
    void validateFileThatDoesNotExistReturnsNothing() {
        final var testFile = "missingtest.txt";

        final var res = FileReader.readFile(testFile);

        assertTrue(res.toList().isEmpty());
    }
}
