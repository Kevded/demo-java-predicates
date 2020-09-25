package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Person;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

public class PersonPredicates {
    public static Predicate<Person> isPersonHasStreetAddress(@NonNull String street) {
        return person -> nonNullPerson().and(hasStreetAddress(street)).test(person);
    }

    public static Predicate<Person> isPersonHasStreetCodeAddress(@NonNull String street) {
        return person -> nonNullPerson().and(hasStreetAddress(street)).test(person);
    }


    public static Predicate<Person> hasStreetAddress(@NonNull String streetAddress) {
        return person -> AddressPredicates.hasStreet(streetAddress).test(person.getAddress());
    }

    public static Predicate<Person> hasStreetCodeAddress(@NonNull String streetCodeAddress) {
        return person -> AddressPredicates.hasStreetCode(streetCodeAddress).test(person.getAddress());
    }

    public static Predicate<Person> nonNullPerson() {
        return person -> Objects.nonNull(person);
    }


}
