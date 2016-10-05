package com.capgemini.javaengineering.gradeladder;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExpectationRepository {

    private List<Expectation> expectations = new ArrayList<Expectation>();

    void loadLinesStream(Stream<String> linesStream) {

        Function<String, Expectation> csvLineToExpectation = new Function<String, Expectation>() {
            public Expectation apply (String csvLine) {
                try {
                    return Expectation.parse(csvLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            };
        };
        expectations = linesStream.map(csvLineToExpectation).collect(Collectors.<Expectation> toList());
    }

    int countAll() {
        return expectations.size();
    }


    Collection<Expectation> getExpectationsForGrade(int grade) {
        return expectations.stream()
                .filter(expectation -> expectation.gradesContains(grade))
                .collect(Collectors.toList());
    }

    Collection<Expectation> getExpectationsForGradeAndTrait(int grade, Trait trait) {
        return getExpectationsForGrade(grade).stream()
                .filter(expectation -> trait.equals(expectation.getTrait()))
                .collect(Collectors.toList());
    }


    List<String> getDistinctSubTraitsForExpectations(Collection<Expectation> expectations) {

        Function<Expectation, String> toSubTrait = new Function<Expectation, String>() {
            @Override
            public String apply(Expectation expectation) {
                return expectation.getSubTrait();
            }
        };

        return expectations.stream()
                .filter(expectation -> !StringUtils.isBlank(expectation.getSubTrait()))
                .map(toSubTrait)
                .distinct()
                .collect(Collectors.<String> toList());
    }

    Collection<Expectation> getExpectationsForGradeTraitAndSubTrait(int grade, Trait trait, String subTrait) {
        return getExpectationsForGradeAndTrait(grade,trait).stream()
                .filter(expectation -> subTrait.equals(expectation.getSubTrait()))
                .collect(Collectors.toList());
    }

    Collection<Expectation> getExpectationsForTrait(Trait trait) {
        return  expectations.stream()
                .filter(expectation -> trait.equals(expectation.getTrait()))
                .collect(Collectors.toList());
    }
}

