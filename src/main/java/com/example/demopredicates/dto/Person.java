package com.example.demopredicates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Person {
    String firstname;
    String lastname;
    Address address;
}
