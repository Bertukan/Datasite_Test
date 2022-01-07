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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//import org.junit.platform.runner.JUnitPlatform;ø

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserModelTest {
    private static final String POJO_PACKAGE = "com.datasite.test.model";

    @Test
    public  void testPojo() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
    }
}


