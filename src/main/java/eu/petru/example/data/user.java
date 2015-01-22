package eu.petru.example.data;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


//For testing purpose
public class user {
    String name;
    String email;
@Autowired
    userDOA userDOA;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<user>getUserList(){
        return userDOA.getUser();
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
