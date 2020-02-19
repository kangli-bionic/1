package de.interview.fizzbuzz.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
public class FizzBuzzInput {
    @NonNull
    private String value;

    public FizzBuzzInput(@NonNull String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
