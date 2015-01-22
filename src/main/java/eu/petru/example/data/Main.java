//package eu.petru.example.data;


/* For testing purpose
public class Main {
    public static void main(String[] args) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("webapp/WEB-INF/spring/spring.xml");

        //Get the EmployeeDAO Bean
        //EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
        //To use JdbcTemplate
        EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);

        //Run some tests for JDBC CRUD operations
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);

        emp.setName("Petru2");
        emp.getEmail("Testr2");

        //Create
        employeeDAO.save(emp);

        //Read



        //Update
        //emp.setRole("CEO");
        //employeeDAO.update(emp);

        //Get All
        List<Employee> empList = employeeDAO.getAll();
        System.out.println(empList);

        //Delete
        //employeeDAO.deleteById(rand);

        //Close Spring Context
        ctx.close();

        System.out.println("DONE");
    }
}
*/