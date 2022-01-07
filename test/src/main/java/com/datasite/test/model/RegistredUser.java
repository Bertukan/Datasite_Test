package com.datasite.test.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegistredUser implements User {
    private String id;
    private String city;
    private String company;
    private String country;
    private String firstName;
    private String lastName;
    private String organizationType;
    private String phone;
    private String state;
    private String zipCode;
    private boolean disclaimerAccepted;
    private String languageCode;
    private String emailAddress;
    private List<String> projectIds = new ArrayList<>();

}
