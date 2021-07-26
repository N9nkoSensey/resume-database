package com.urise.webapp.model;

public enum ContactType {
    PHONE("Phone"),
    MOBILE("Mobile phone"),
    HOME_PHONE("Home phone"),
    SKYPE("Skype"),
    MAIL("e-mail"),
    LINKEDIN("Profile LinkedIn"),
    GITHUB("Profile GitHub"),
    STACKOVERFLOW("Profile Stackoverflow"),
    HOME_PAGE("Home page");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
