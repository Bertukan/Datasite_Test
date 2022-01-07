package com.datasite.test.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UnRegistredUser implements User {

    private String id;
    private String emailAddress;
    private String languageCode;
    private String registrationId;
    private String registrationIdGeneratedTime;
    private List<String> projectIds = new ArrayList<>();



}
