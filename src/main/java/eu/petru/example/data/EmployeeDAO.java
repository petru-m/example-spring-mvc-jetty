package eu.petru.example.data;

import java.util.List;


public interface EmployeeDAO {
    public void save(Employee employee);
    public List<Employee> getAll();


}
