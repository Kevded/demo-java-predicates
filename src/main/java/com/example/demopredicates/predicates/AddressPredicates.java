package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Address;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

public class AddressPredicates {


    public static Predicate<Address> hasStreetCode(@NonNull String streetCode) {
        return address -> nonNullAddress().and(equalsIgnoreCaseStreetCode(streetCode)).test(address);
    }


    public static Predicate<Address> hasStreet(@NonNull String street) {
        return address -> nonNullAddress().and(equalsIgnoreCaseStreet(street)).test(address);
    }


    public static Predicate<Address> equalsIgnoreCaseStreet(@NonNull String street) {
        return address -> street.equalsIgnoreCase(address.getStreet());
    }

    public static Predicate<Address> equalsIgnoreCaseStreetCode(@NonNull String streetCode) {
        return address -> streetCode.equalsIgnoreCase(address.getStreetCode());
    }

    public static Predicate<Address> nonNullAddress() {
        return address -> Objects.nonNull(address);
    }
}
