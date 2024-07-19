package in.spring.dao;

import java.util.List;

import in.spring.model.Employee;

public interface IEmployeeDAO {

	public List<Employee> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;
}
