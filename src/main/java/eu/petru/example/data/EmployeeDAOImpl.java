package eu.petru.example.data;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by petru on 09.01.2015.
 */

@Component()
public class EmployeeDAOImpl {


    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){this.dataSource=dataSource;}

    @Transactional
    public void save(Employee employee){
        String query="insert into user(name,email)value(,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=dataSource.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1,employee.getName());
            ps.setString(2,employee.getEmail());
            int out=ps.executeUpdate();
            if(out!=0){
                System.out.println("Employee "+employee.getName());
            }else {System.out.println("Failed "+employee.getName());}
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {


                ps.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            }


    }
    public List<Employee> getAll(){
        String query="select name,email from user";
        List<Employee> empList=new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=dataSource.getConnection();
            ps=con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee emp = new Employee();

                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                empList.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empList;
    }



}




