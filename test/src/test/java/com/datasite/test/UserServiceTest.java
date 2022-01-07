package com.datasite.test;

import com.datasite.test.model.Project;
import com.datasite.test.model.RegistredUser;
import com.datasite.test.model.UnRegistredUser;
import com.datasite.test.model.User;
import com.datasite.test.service.ProjectService;
import com.datasite.test.service.RegisteredUserService;
import com.datasite.test.service.UnRegistredUserService;
import com.datasite.test.service.UsersService;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {




    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UsersService usersService() {
            return new UsersService();
        }
    }

    @InjectMocks
    private UsersService usersService;
    @Mock
    ProjectService projectService;
    @Mock
    RegisteredUserService registeredUserService;
    @Mock
    UnRegistredUserService unRegistredUserService;

    @Before
    public void setUp() {
        List<Project> projectsList= new ArrayList<>();
        List<RegistredUser> registredUsers= new ArrayList<>();
        List<UnRegistredUser> UnregistredUsers= new ArrayList<>();
        Project project = new Project();
        UnRegistredUser unregistredUser= new UnRegistredUser();
        RegistredUser registredUser= new RegistredUser();
        project.setId("1");
        project.setProjectId("1");
        project.setUserId("1");
        projectsList.add(project);
        registredUser.setId("1");
        registredUser.setCity("Irving");
        unregistredUser.setId("2");
        registredUsers.add(registredUser);
        UnregistredUsers.add(unregistredUser);

        Mockito.when(projectService.getProjects())
                .thenReturn(projectsList);

        Mockito.when(registeredUserService.getUsers())
                .thenReturn(registredUsers);

        Mockito.when(unRegistredUserService.getUsers())
                .thenReturn(UnregistredUsers);
    }

    @Test
    public void testUserService() {
        List<User> userList= usersService.getUsers();
        assertNotNull(userList);
    }



}
