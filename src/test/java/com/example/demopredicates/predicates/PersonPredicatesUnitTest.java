package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Address;
import com.example.demopredicates.dto.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PersonPredicatesUnitTest {


    @Test
    public void PersonPredicates_hasNicknameAndHasNicknamePrefixAndAsStreetAddress_returnTrue() {
        // GIVEN
        var nicknames = List.of("el patron", "pablo");
        var address = Address.builder().street("forest").build();
        var person = Person.builder().nicknames(nicknames).address(address).build();
        // WHEN
        var result = PersonPredicates.hasNicknameAndHasNicknamePrefixAndAsStreetAddress("pablo", "el", "forest").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasNicknameStartWith_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo1")).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasNicknameStartWith("el").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_equalsIgnoreCaseNickname_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo1")).build();
        // WHEN
        var result = PersonPredicates.equalsIgnoreCaseNickname("pablo1").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasNickname_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo")).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasNickname("pablo").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasStreetCodeAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().streetCode("222").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasStreetCodeAddress("222").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasStreetAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().street("Ferdinand2").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasStreetAddress("Ferdinand2").test(person);
        // THEN
        assertTrue(result);
    }


    @Test
    public void PersonPredicates_hasStreetAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().street("Ferdinand").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasStreetAddress("Ferdinand").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasStreetCodeAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().streetCode("45").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasStreetCodeAddress("45").test(person);
        // THEN
        assertTrue(result);
    }
}
