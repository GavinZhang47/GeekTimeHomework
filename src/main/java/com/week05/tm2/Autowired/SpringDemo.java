package com.week05.tm2.Autowired;

import com.week05.tm2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDemo {

//    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/week05/tm2/Autowired/applicationContext.xml");

    @Autowired
    User user;

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/week05/tm2/Autowired/applicationContext.xml");
        User user = (User) context.getBean("user");
        SpringDemo springDemo = new SpringDemo();
        System.err.println(springDemo.user.toString());
    }
}
