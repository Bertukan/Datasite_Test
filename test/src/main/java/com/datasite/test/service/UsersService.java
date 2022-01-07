package com.datasite.test.service;

import com.datasite.test.model.Project;
import com.datasite.test.model.RegistredUser;
import com.datasite.test.model.UnRegistredUser;
import com.datasite.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UsersService implements  IUserService{

    @Autowired
    UnRegistredUserService unRegistredUserService;

    @Autowired
    RegisteredUserService registeredUserService;

    @Autowired
    ProjectService projectService;

@Override
    public List<User> getUsers() {
        List<RegistredUser> registeredUsers = registeredUserService.getUsers();
        List<UnRegistredUser> unregistredUserList = unRegistredUserService.getUsers();
        List<Project> projects = projectService.getProjects();
        HashMap<String, List<String>> map = new HashMap<>();
        map = getAllProjectsOfUser(projects);
        List<User> response = new ArrayList<>();
        addProjectsForRegisteredUsers(registeredUsers, map, response);
        addProjectsForUnregistredUsers(unregistredUserList, map, response);
        return response;
    }




    private void addProjectsForUnregistredUsers(List<UnRegistredUser> unregistredUserList, HashMap<String, List<String>> map, List<User> response) {
        for (UnRegistredUser user : unregistredUserList) {
            String userId = user.getId();
            if (map.containsKey(userId)) {
                List<String> projectIds = map.get(userId);
                user.setProjectIds(projectIds);
                response.add(user);
            } else {
                response.add(user);
            }
        }
    }

    private void addProjectsForRegisteredUsers(List<RegistredUser> registeredUsers, HashMap<String, List<String>> map, List<User> response) {
        for (RegistredUser user : registeredUsers) {
            String userId = user.getId();
            if (map.containsKey(userId)) {
                List<String> projectIds = map.get(userId);
                user.setProjectIds(projectIds);
                response.add(user);
            } else {
                response.add(user);
            }
        }
    }


    private HashMap<String, List<String>> getAllProjectsOfUser(List<Project> projects) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (Project p : projects) {
            String key = p.getUserId();
            List<String> ids = new ArrayList<>();
            if (map.containsKey(key)) {
                ids = map.get(key);
                ids.add(p.getProjectId());
                map.put(key, ids);
            } else {
                ids.add(p.getProjectId());
                map.put(key, ids);
            }
        }
        return map;
    }
}

