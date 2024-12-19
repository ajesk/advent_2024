package io.acode.days.seventeen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyComputerTest {

    @Test
    void outputVariousPatterns() {
        for (int i = 0; i < 1024; i++) {
            MyComputer myComputer = new MyComputer("seventeen/real.txt");
            System.out.println(i + " : " + Integer.toBinaryString(i) + " : " + myComputer.process(i));
        }
    }

    @Test
    void ohBoyLetsSee() {
        MyComputer myComputer = new MyComputer("seventeen/real.txt");
        assertEquals(0, myComputer.findProgram(0));
    }
}
