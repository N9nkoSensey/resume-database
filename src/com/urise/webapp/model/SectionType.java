package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Personal qualities"),
    OBJECTIVE("Position"),
    ACHIEVEMENTS("Achievements"),
    QUALIFICATION("Qualification"),
    EXPERIENCE("Work experience"),
    EDUCATION("Education");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
