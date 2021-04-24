package com.week05.tm2.constructor;

import com.week05.tm2.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDemo {
    
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/week05/tm2/constructor/applicationContext.xml");
        User user = (User) context.getBean("user");
        System.err.println(user.toString());
    }
}
