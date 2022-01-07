package com.datasite.test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datasite.test.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${project.url}")
    String url;

    public List<Project> getProjects() {
        ObjectMapper mapper = new ObjectMapper();
        List<Project> projects = new ArrayList<>();
        try {
            projects = restTemplate.getForObject(url, List.class);
        } catch (RestClientException e) {
            log.info("call not succefull");
        }
        List<Project> projectsResponse = mapper.convertValue(
                projects,
                new TypeReference<List<Project>>() {
                }
        );

        return projectsResponse;

    }

}
