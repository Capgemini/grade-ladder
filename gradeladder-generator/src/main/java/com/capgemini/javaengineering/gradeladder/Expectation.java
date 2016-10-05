package com.capgemini.javaengineering.gradeladder;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Expectation {

    private final String description;
    private final List<Integer> grades;
    private final Trait trait;
    private final String subTrait;

    Expectation(String description, List<Integer> grades, Trait trait, String subTrait) {
        this.description = description;
        this.grades = grades;
        this.trait = trait;
        this.subTrait = subTrait;
    }

    Trait getTrait() {
        return trait;
    }

    String getDescription() {
        return description;
    }

    boolean gradesContains(int grade) {
        return this.grades.contains(grade);
    }

    static Expectation parse(String csvString) throws IOException {
        CSVParser parser = new CSVParser();
        String[] parts = parser.parseLine(csvString);
        Expectation expectation = new Builder()
                .withDescription(parts[0])
                .forGrades(parts[1])
                .forTrait(Trait.valueOf(parts[2].toUpperCase()))
                .withSubTrait(parts[3])
                .build();
        return expectation;
    }

    String getSubTrait() {
        return subTrait;
    }

    static class Builder {

        private List<Integer> grades;
        private Trait trait;
        private String description;
        private String subTrait;

        Builder() {
            this.grades = new ArrayList<Integer>();
        }

        Builder forGrade(int grade) {
            this.grades.add(grade);
            return this;
        }

        Builder forTrait(Trait trait) {
            this.trait = trait;
            return this;
        }

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Expectation build() {
            return new Expectation(
                    this.description, this.grades, this.trait, this.subTrait);
        }

        Builder forGrades(String pipeDelimitedGrades) {
            String[] grades = pipeDelimitedGrades.split("\\|");
            for (String grade : grades) {
                this.grades.add(Integer.valueOf(grade));
            }
            return this;
        }

        Builder withSubTrait(String subTrait) {
            this.subTrait = subTrait;
            return this;
        }
    }


}
