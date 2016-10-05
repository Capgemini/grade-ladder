package com.capgemini.javaengineering.gradeladder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExpectationRepositoryTest {

    private Collection<String> lines;
    private ExpectationRepository repository;

    @Before
    public void setUp() throws Exception {
        lines = new ArrayList<String>();
        lines.add("Test1,1,DEX,");
        lines.add("Test2a,2,DEX,");
        lines.add("Test2b,2,DEX,");
        lines.add("Test2c,2,STR,");
        lines.add("Test3a,3,STR,A");
        lines.add("Test3b,3,WIS,A");
        lines.add("Test3c,3,WIS,B");

        repository = new ExpectationRepository();
        repository.loadLinesStream(lines.stream());
    }

    @Test
    public void testLoadFromStreamOfStrings() throws Exception {
        assertEquals(lines.size(),repository.countAll());
    }

    @Test
    public void testGetExpectationsForGrade() throws Exception {
        Collection<Expectation> expectations = repository.getExpectationsForGrade(1);
        assertEquals(1, expectations.size());

        expectations = repository.getExpectationsForGrade(2);
        assertEquals(3, expectations.size());
    }

    @Test
    public void testGetExpectationsForGradeAndTrait() throws Exception {
        Collection<Expectation> expectations = repository.getExpectationsForGradeAndTrait(1, Trait.DEX);
        assertEquals(1, expectations.size());

        expectations = repository.getExpectationsForGradeAndTrait(2,Trait.DEX);
        assertEquals(2, expectations.size());

        expectations = repository.getExpectationsForGradeAndTrait(2,Trait.STR);
        assertEquals(1,expectations.size());
    }

    @Test
    public void testGetDistinctSubTraitsForExpectations() throws Exception {
        Collection<Expectation> expectations = repository.getExpectationsForGrade(3);
        List<String> traits = repository.getDistinctSubTraitsForExpectations(expectations);
        assertEquals(2, traits.size());
        assertTrue(traits.contains("A"));
        assertTrue(traits.contains("B"));
    }

    @Test
    public void testGetExpectationsForGradeTraitAndSubTrait() throws Exception {
        Collection<Expectation> expectations = repository.getExpectationsForGradeTraitAndSubTrait(3,Trait.WIS,"A");
        assertEquals(1,expectations.size());
    }
}
