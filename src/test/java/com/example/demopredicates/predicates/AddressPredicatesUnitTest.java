package com.example.demopredicates.predicates;

import com.example.demopredicates.dto.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AddressPredicatesUnitTest {

    @Test
    public void AddressPredicates_hasStreet_returnTrue(){
        // GIVEN
        var address = Address.builder().street("Ferdinand").build();
        // WHEN
        var result = AddressPredicates.hasStreet("Ferdinand").test(address);
        // THEN
        assertTrue(result);
    }
    @Test
    public void AddressPredicates_hasStreetCode_returnTrue(){
        // GIVEN
        var address = Address.builder().streetCode("22").build();
        // WHEN
        var result = AddressPredicates.hasStreetCode("22").test(address);
        // THEN
        assertTrue(result);
    }
}
