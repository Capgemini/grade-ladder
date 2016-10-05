package com.capgemini.javaengineering.gradeladder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

class ByGradeExpectationRenderer extends ExpectationRenderer {

    private final int grade;

    ByGradeExpectationRenderer(ExpectationRepository repository, int grade) {
        super(repository);
        this.grade = grade;
    }

    String render() {
        addHeaderToOutput();
        addGradeSubHeadingToOutput(grade);
        for (Trait trait : Trait.values()) {
            addTraitswithExpectationsToOutput(trait);
        }
        return StringUtils.join(output,"\n");
    }

    private void addTraitswithExpectationsToOutput(Trait trait) {
        addTraitHeaderToOutput(trait);
        if (trait.equals(Trait.WIS)) {
            addSubTraitsWithExpectationsToOutput(trait);
        }
        else {
            addExpectationsForTraitToOutput(trait);
        }
    }

    private void addExpectationsForTraitToOutput(Trait trait) {
        output.addAll(
                repository.getExpectationsForGradeAndTrait(grade, trait).stream()
                        .map(expectationToDescription)
                        .collect(Collectors.<String>toList()));
    }

    private void addSubTraitsWithExpectationsToOutput(Trait trait) {
        List<String> subTraits = repository.getDistinctSubTraitsForExpectations(repository.getExpectationsForGrade(grade));
        for (String subTrait : subTraits) {
            addSubTraitHeaderAndExpectationsToOutput(trait, subTrait);
        }
    }

    private void addSubTraitHeaderAndExpectationsToOutput(Trait trait, String subTrait) {
        addSubTraitSubHeadingToOutput(subTrait);
        output.addAll(
                repository.getExpectationsForGradeTraitAndSubTrait(grade, trait, subTrait).stream()
                        .map(expectationToDescription)
                        .collect(Collectors.<String> toList()));
    }

}
