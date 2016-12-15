package com.capgemini.javaengineering.gradeladder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;

public class BookSummaryRenderer extends ExpectationRenderer {

    BookSummaryRenderer(ExpectationRepository repository) {
        super(repository);
    }

    String render() {
        addHeaderToOutput();

        Collection<Grade> grades = Arrays.asList(Grade.values()).stream().sorted((g1, g2) -> Integer.compare(g1.getGrade(), g2.getGrade())).collect(Collectors.toList());
        for (Grade grade : grades) {
            addGradeSubHeadingToOutput(grade);
        }

        return StringUtils.join(output, "\n");
    }

    void addHeaderToOutput() {
        output.add("# Summary ");
    }

    void addGradeSubHeadingToOutput(Grade grade) {
        String formatString = "/book/A Grades/A%02d-%s";
        String linkString = "A%02d-%s";
        output.add("* [" + String.format(linkString, grade.getGrade(), grade.getTitle()) + "](" + String.format(formatString, grade.getGrade(), grade.getTitle()) + "/README.md)");
    }
}