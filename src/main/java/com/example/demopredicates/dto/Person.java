package com.example.demopredicates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Person {
    private String firstname;
    private String lastname;
    private Address address;
    private List<String> nicknames;
}
