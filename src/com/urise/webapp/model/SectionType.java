package com.urise.webapp.model;

public enum SectionType {
    OBJECTIVE("Position"),
    PERSONAL("Personal qualities"),
    ACHIEVEMENTS("Achievements"),
    QUALIFICATIONS("Qualifications"),
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
