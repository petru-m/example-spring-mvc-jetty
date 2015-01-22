

package eu.petru.example.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;


//For testing purpose
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("webapp/WEB-INF/spring/Database.xml");

        userDOA userDoa=(userDOA)context.getBean("dataSource");

        List<user> usr=userDoa.getUser();

        for (user u : usr)
        {
            System.out.println(u.getName());
            System.out.println(u.getEmail());


        }

    }
}
