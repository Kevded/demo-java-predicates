package com.example.demopredicates.predicates;

import org.springframework.lang.NonNull;

import java.util.function.Predicate;

public class StringPredicates {

    public static Predicate<String> equalsIgnoreCaseString(@NonNull String value) {
        return value::equalsIgnoreCase;
    }

    public static Predicate<String> startWithString(@NonNull String value) {
        return str -> str.startsWith(value);
    }
}
