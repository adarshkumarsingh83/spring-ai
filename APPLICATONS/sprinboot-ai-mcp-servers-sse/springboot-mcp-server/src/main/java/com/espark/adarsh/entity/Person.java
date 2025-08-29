package com.espark.adarsh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;
    private String personId;
    private String firstName;
    private String lastName;

}
