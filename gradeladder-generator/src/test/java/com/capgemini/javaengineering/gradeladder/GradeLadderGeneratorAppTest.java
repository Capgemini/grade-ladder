package com.capgemini.javaengineering.gradeladder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeLadderGeneratorAppTest {

    @Test
    public void createFileNameShouldFormatG1AsExpected() throws Exception {

        String expectedFileName = "test/flat/SE_Ladder-A01-ApprenticeSoftwareEngineer.md";
        Grade g = Grade.ONE;
        assertEquals(expectedFileName, GradeLadderGeneratorApp.createFileName("test", g));

    }

    @Test
    public void createFileNameShouldFormatG10AsExpected() throws Exception {

        String expectedFileName = "test/flat/SE_Ladder-A10-PrincipleSoftwareEngineer.md";
        Grade g = Grade.TEN;
        assertEquals(expectedFileName, GradeLadderGeneratorApp.createFileName("test", g));

    }

}
