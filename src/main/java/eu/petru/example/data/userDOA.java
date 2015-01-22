package eu.petru.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//For testing purpose
@Component
public class userDOA {
    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc){
        this.jdbc=new JdbcTemplate(jdbc);
    }



    public List<user> getUser(){
        return jdbc.query("select * from user", new RowMapper<user>() {



            public user mapRow(ResultSet rs, int i) throws SQLException {
              user user =new user();

                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));


                return  user;
            }
        });


    }






}
