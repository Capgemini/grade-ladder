package com.capgemini.javaengineering.gradeladder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ConsistencyExpectationRenderer extends ExpectationRenderer {

    ConsistencyExpectationRenderer(ExpectationRepository repository) {
        super(repository);
    }

    String render() {
        addHeaderToOutput();
        for (Trait trait : Trait.values()) {
            addTraitHeaderToOutput(trait);
            if (Trait.WIS.equals(trait)) {
                addSubTraitsWithExpectationsToOutput(trait);
            } else {
                for (int grade = 1; grade <= 10; grade++) {
                    addGradeSubHeadingToOutput(grade);
                    addExpectationsForGradeAndTraitToOutput(grade, trait);
                }
            }
        }
        return StringUtils.join(output, "\n");
    }

    private void addSubTraitsWithExpectationsToOutput(Trait trait) {
        List<String> subTraits = repository.getDistinctSubTraitsForExpectations(repository.getExpectationsForTrait(trait));
        for (String subTrait : subTraits) {
            addSubTraitSubHeadingToOutput(subTrait);
            for (int grade = 1; grade <= 5; grade++) {
                addGradeSubHeadingToOutput(grade);
                addExpectationsForGradeTraitAndSubTraitToOutput(grade, trait, subTrait);
            }
        }
    }

    private void addExpectationsForGradeTraitAndSubTraitToOutput(int grade, Trait trait, String subTrait) {
        output.addAll(
                repository.getExpectationsForGradeTraitAndSubTrait(grade, trait, subTrait).stream()
                        .map(expectationToDescription)
                        .collect(Collectors.<String> toList()));
    }

    private void addExpectationsForGradeAndTraitToOutput(int grade, Trait trait) {
        output.addAll(
                repository.getExpectationsForGradeAndTrait(grade, trait).stream()
                .map(expectationToDescription)
                .collect(Collectors.<String> toList())
        );
    }

}