package com.example.demopredicates.predicates;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class StringPredicatesUnitTest {

    @Test
    public void StringPredicates_startWithString_returnTrue() {
        // GIVEN
        var person = "test-example";
        // WHEN
        var result = StringPredicates.startWithString("test-").test(person);
        // THEN
        assertTrue(result);
    }
    @Test
    public void StringPredicates_equalsIgnoreCaseString_returnTrue() {
        // GIVEN
        var person = "test";
        // WHEN
        var result = StringPredicates.equalsIgnoreCaseString("test").test(person);
        // THEN
        assertTrue(result);
    }
}
