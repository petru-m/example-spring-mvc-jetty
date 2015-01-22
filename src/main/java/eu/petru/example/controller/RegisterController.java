package eu.petru.example.controller;

import eu.petru.example.data.Employee;
import eu.petru.example.data.EmployeeDAO;
import org.parse4j.ParseException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/register")

//Registration Controller

public class RegisterController {


    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Employee userForm = new Employee();
        model.put("userForm", userForm);


        return "Registration";
    }


//Show registration data and insert into database
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") Employee employee,
                                      Map<String, Object> model) throws ParseException {

   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("webapp/WEB-INF/spring/root-context.xml");
   EmployeeDAO employeeDAO =ctx.getBean("employeeDAOJDBCTemplate",EmployeeDAO.class);
        
        //Getting data and inserting into database
        Employee emp=new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        employeeDAO.save(emp);



        //Show data in console
        List<Employee> empList=employeeDAO.getAll();
        System.out.println(empList);
        
        ctx.close();

        /*Use parse4j for registration
        ParseUser user=new ParseUser();
        user.setUsername(employee.getName());
        user.setEmail(employee.getEmail());
        user.signUp();
        */
       
      
        


        return "RegistrationSuccess";

    }



}

