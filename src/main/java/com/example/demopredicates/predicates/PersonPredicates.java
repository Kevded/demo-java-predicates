package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Person;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

import static com.example.demopredicates.predicates.StringPredicates.equalsIgnoreCaseString;
import static com.example.demopredicates.predicates.StringPredicates.startWithString;

public class PersonPredicates {

    public static Predicate<Person> hasNicknameAndHasNicknamePrefixAndAsStreetAddress(@NonNull String nickname, String nicknamePrefix, String streetAddress) {
        return person -> hasNonNullPersonAndHasNickname(nickname)
                .and(hasNonNullPersonAndHasNicknameStartWith(nicknamePrefix))
                .and(hasNonNullPersonAndHasStreetAddress(streetAddress))
                .test(person);
    }


    public static Predicate<Person> hasNonNullPersonAndHasNicknameStartWith(@NonNull String nicknamePrefix) {
        return person -> nonNullPerson().and(hasNicknameStartWith(nicknamePrefix)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasNickname(@NonNull String nickname) {
        return person -> nonNullPerson().and(equalsIgnoreCaseNickname(nickname)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasStreetAddress(@NonNull String streetAddress) {
        return person -> nonNullPerson().and(hasStreetAddress(streetAddress)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasStreetCodeAddress(@NonNull String streetCodeAddress) {
        return person -> nonNullPerson().and(hasStreetCodeAddress(streetCodeAddress)).test(person);
    }


    public static Predicate<Person> equalsIgnoreCaseNickname(@NonNull String nickname) {
        return person -> person.getNicknames().stream().anyMatch(equalsIgnoreCaseString(nickname));
    }

    public static Predicate<Person> hasNicknameStartWith(@NonNull String nicknamePrefix) {
        return person -> person.getNicknames().stream().anyMatch(startWithString(nicknamePrefix));
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
