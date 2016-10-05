package com.capgemini.javaengineering.gradeladder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExpectationTest {

    @Test
    public void testExpectationBuilder() throws Exception {

        String desc = "You are developing a deep expertise in a core language and / or technology, and gaining awareness of others.";
        String desc2 = "You are developing a deep expertise in a core language and / or technology, and gaining awareness of others.";

        Expectation expectation = new Expectation.Builder()
                .forGrade(3).forGrade(4).forGrade(5)
                .forTrait(Trait.DEX)
                .withDescription(desc)
                .build();

        assertNotNull(expectation);
        assertEquals(Trait.DEX, expectation.getTrait());
        assertEquals(desc2, expectation.getDescription());
        assertTrue(expectation.gradesContains(3));
    }

    @Test
    public void testExpectationBuildsWithGrades() throws Exception {

        Expectation expectation = new Expectation.Builder()
                .withDescription("A")
                .forTrait(Trait.DEX)
                .forGrades("3|4|5")
                .build();

        assertTrue(expectation.gradesContains(3));
        assertTrue(expectation.gradesContains(4));
        assertTrue(expectation.gradesContains(5));

    }

    @Test
    public void testCSVParse() throws Exception {
        Expectation expectation = Expectation.parse("\"This is a test\",\"1|2\",\"Str\",\"Another Test\"");

        assertTrue(expectation.gradesContains(1));
        assertTrue(expectation.gradesContains(2));

        assertEquals("This is a test", expectation.getDescription());

        assertEquals(Trait.STR, expectation.getTrait());

        assertEquals("Another Test", expectation.getSubTrait());
    }
}
