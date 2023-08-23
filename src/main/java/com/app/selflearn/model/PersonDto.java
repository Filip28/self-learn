package com.app.selflearn.model;

import lombok.Builder;

@Builder
public record PersonDto(String name, String surname, int age, double height, String gender) {
}
