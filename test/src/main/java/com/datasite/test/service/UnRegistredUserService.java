package com.datasite.test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datasite.test.model.UnRegistredUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnRegistredUserService {


    @Autowired
    RestTemplate restTemplate;

    @Value("${unregistred.url}")
    private String url;

    public List<UnRegistredUser> getUsers()  {
        ObjectMapper mapper = new ObjectMapper();
        List<UnRegistredUser> unRegisteredUsers= new ArrayList<>();
        try {
            unRegisteredUsers   = restTemplate.getForObject(url, List.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        List<UnRegistredUser> unRegistredUsersLsit = mapper.convertValue(
                unRegisteredUsers,
                new TypeReference<List<UnRegistredUser>>() {
                }
        );
        return unRegistredUsersLsit;

    }
}
