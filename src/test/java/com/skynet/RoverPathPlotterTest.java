package com.skynet;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RoverPathPlotterTest {

    private String buildPath(String instructions) {
        return new RoverPathPlotter().executeInstructions(instructions).getPathString();
    }

    @Test
    public void testBasis() {
        assertEquals(
                buildPath("FFF"),
                "---\n"

        );

        assertEquals(
                buildPath("RFFF"),
                "+\n|\n|\n|\n"
        );

        assertEquals(
                buildPath("LFFF"),
                "|\n|\n|\n+\n"
        );

        assertEquals(
                buildPath("FFFFLFFLFFLFFF"),
                " +-+\n" +
                        " | |\n" +
                        "-+-+\n" +
                        " |  \n"
        );
    }
}
