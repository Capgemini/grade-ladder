package com.capgemini.javaengineering.gradeladder;

enum Grade {

    ONE (1, "ApprenticeSoftwareEngineer"),
    TWO (2, "ApprenticeSoftwareEngineer"),
    THREE (3, "SoftwareEngineer"),
    FOUR (4, "SoftwareEngineer"),
    FIVE (5, "SoftwareEngineer"),
    SIX (6, "SeniorSoftwareEngineer"),
    SEVEN (7, "SeniorSoftwareEngineer"),
    EIGHT (8, "LeadSoftwareEngineer"),
    NINE (9, "PrincipleSoftwareEngineer"),
    TEN (10, "PrincipleSoftwareEngineer");

    private final int grade;
    private String title;

    Grade (int grade, String title) {
        this.grade = grade;
        this.title = title;
    }

    String getTitle() {
        return title;
    }


    int getGrade() {
        return grade;
    }

    Grade fromInt(int grade) {
        switch (grade) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            default:
                throw new AssertionError("Unknown Grade");
        }
    }

}
