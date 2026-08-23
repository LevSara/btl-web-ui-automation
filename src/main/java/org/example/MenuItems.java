package org.example;

public enum MenuItems {
    RIGHTS("מיצוי זכויות"),
    BENEFITS("קצבאות והטבות"),
    INSURANCE("דמי ביטוח"),
    CONTACT("יצירת קשר"),
    BRANCHES("סניפים");

    private final String displayName;

    MenuItems(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
