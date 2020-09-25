package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Address;
import com.example.demopredicates.dto.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PersonPredicatesUnitTest {

    @Test
    public void AddressRules_hasStreetAddress_returnTrue(){
        // GIVEN
        var address = Address.builder().street("Ferdinand").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasStreetAddress("Ferdinand").test(person);
        // THEN
        assertTrue(result);
    }
}
