package com.capgemini.javaengineering.gradeladder;

enum Trait {


    DEX ("Technical Skills", "Dex"),
    T("Soft Skills", "T"),
    STR("Getting Code Live", "Str"),
    WIS("Impact", "Wis"),
    FEL("Team Leadership","Tel"),
    CHA("Advocacy and Ambassadorship","Cha");

    String getDescription() {
        return description;
    }

    String getShortHand() {
        return shortHand;
    }

    private final String description;
    private final String shortHand;

    Trait(String description, String shortHand) {
        this.description = description;
        this.shortHand = shortHand;
    };

}
