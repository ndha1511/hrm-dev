package com.dev.hrm_api.models.enums;

public enum PermEnum {
    create("create"),
    edit("edit"),
    view("view"),
    delete("delete");

    private final String value;

    PermEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
