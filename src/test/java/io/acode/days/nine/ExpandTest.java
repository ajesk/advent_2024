package io.acode.days.nine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpandTest {

    @Test
    void testBase() {
        String base = "12345";
        Expand expand = new Expand();
        var res = expand.apply(base);

        assertEquals(15, res.size());
    }
}
