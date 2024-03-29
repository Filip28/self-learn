package com.app.selflearn.model;

import lombok.Getter;

@Getter
public enum Gender {
    MAN("MAN"),
    WOMAN("WOMAN"),
    OTHER("OTHER");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

}
