package eu.petru.example.tests;


import eu.petru.example.controller.IndexController;
import eu.petru.example.data.Employee;
import eu.petru.example.data.EmployeeDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParsePush;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eu/petru/example/test/config/springTest.xml")



public class EmpTest {

     String app_id="tagDUSM8qg0wstc8uCXIgDI53RiUfddf0IY5eKeq";
     String api_key="Fp84U6aax6lmoUiuK8NvBGmPfU4KtIZVkTwBVTvt";
  
    
    SocketConnector conn = new SocketConnector();
    private static Log log = LogFactory.getLog(EmpTest.class);

    @InjectMocks
    IndexController indexController;
    private MockMvc mockMvc;
/*
    @Before
    public void setup2(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
    }
    */
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new IndexController())
                .setViewResolvers(viewResolver)
                .build();

        
    //jetty start
        Server jettyServer = new Server();
        jettyServer.setConnectors(new Connector[]{conn});
        WebAppContext wah = new WebAppContext();
        wah.setContextPath("/register");
        wah.setWar("src/main/webapp");
        jettyServer.setHandler(wah);
        jettyServer.start();

    }





    //Push Notification test
    @Test
    public void parsepush() throws ParseException {
        Parse.initialize(app_id, api_key);
        ParsePush parsePush=new ParsePush();
        LinkedList<String>channel=new LinkedList<>();
        parsePush.setData(new JSONObject("{\"data\": { \"alert\": \"PaseTest\"},\"channel\":\"Test\"}"));
        parsePush.send();

    }


    
// Testing Register Controller
@Test
    public void testInsert(){


    conn.setPort(8081);
        log.info("testing insertEmp()...");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("webapp/WEB-INF/spring/root-context.xml");
        EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);

        String parentName = "UtestName";
        String parentEmail = "UtestEmail";

        Employee parent = new Employee();
        parent.setName(parentName);
        parent.setEmail(parentEmail);

        employeeDAO.save(parent);
        log.info(parent);//show data


        assertNotNull("failure - EMP is null", parent);
        assertTrue("failure - emp name is not right", parent.getName().equals(parentName));
        assertTrue("failure - emp email is not right", parent.getEmail().equals(parentEmail));



    List<Employee> employeeList=employeeDAO.getAll();
    log.info(employeeList);//show all employees


    }

    }



