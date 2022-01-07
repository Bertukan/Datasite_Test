package com.datasite.test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datasite.test.model.RegistredUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisteredUserService {

    @Value("${registered.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<RegistredUser> getUsers()  {
        ObjectMapper mapper= new ObjectMapper();
        List<RegistredUser> registeredUsers= new ArrayList<>();
        try {
           registeredUsers = restTemplate.getForObject(url, List.class);
        }
        catch (Exception e){
        log.info("service call not succesfull ");
        }

        List<RegistredUser> users = mapper.convertValue(
                registeredUsers,
                new TypeReference<List<RegistredUser>>() {
                }
        );

        return users;
    }}
