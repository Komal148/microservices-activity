package com.stackroute.config;

import com.stackroute.service.UserService;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


//A Java class decorated with @Component is found during classpath scanning and registered
// in the context as a Spring bean
@Component
@Configuration
//it is used to connect to the property file
@PropertySource("classpath:app2.properties")

public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent>{


//    This allows MyListener to be notified when the context has refreshed and
//    one can use that to run arbitrary code when the application context has fully started.
    private UserService userService;

    //This will get the constant values which are declared in property
    @Value("${userId}")
    private int userId;

    //This will get the constant values which are declared in property
    @Value("${userName}")
    private String userName;

    //This will get the constant values which are declared in property
    @Value("${userEmail}")
    private String userEmail;


    @Value("${userAge}")
    private String userAge;

    @Value("${userFirstName}")
    private String userFirstName;



    //A constructor @Autowired annotation indicates that the constructor should be autowired when creating the bean,
    // even if no <constructor-arg> elements are used while configuring the bean in XML file
    @Autowired
    public ApplicationListener(UserService musicService) {
        this.userService = musicService;
    }

    //Application events are available since the very beginning of the Spring framework
// as a mean for loosely coupled components to exchange information.
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User();
        user.setUserAge(userAge);
        user.setUserEmail(userEmail);
        user.setUserFirstName(userFirstName);
        user.setUserId(userId);
        user.setUserName(userName);

        try {
            userService.saveUser(user);
        }
        catch (Exception e){}
    }


}