package eu.petru.example.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by petru on 09.01.2015.
 */
public class EmployeeDAOJDBCTemplateImpl  implements  EmployeeDAO{

    private DataSource dataSource;


    private void setDataSource(DataSource dataSource) {this.dataSource=dataSource;}

@Override
    public void save (Employee employee){

    String query="insert into user (name,email) values(?,?)";
    JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);

    Object []args=new Object[]{employee.getName(),employee.getEmail()
    };

    int out=jdbcTemplate.update(query,args);
    if(out!=0){
        System.out.println("Employee "+employee.getName());
    }else {System.out.println("Failed "+employee.getName());
    }

}

        public List<Employee> getAll(){
            String query = "select name,email FROM  user";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Employee> empList = new ArrayList<Employee>();

            List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);

            for(Map<String,Object> empRow : empRows){
                Employee emp = new Employee();

                emp.setName(String.valueOf(empRow.get("name")));
                emp.getEmail(String.valueOf(empRow.get("email")));
                empList.add(emp);
            }
            return empList;
        }


    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }


}
