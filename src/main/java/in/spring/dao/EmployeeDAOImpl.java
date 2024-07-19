package in.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.spring.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_DESG="SELECT EMPNO, ENAME, SAL FROM EMP WHERE JOB IN(?, ?, ?)";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Employee> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
	    Connection con = dataSource.getConnection();
	    PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESG);
	    ps.setString(1, desg1);
	    ps.setString(2, desg2);
	    ps.setString(3, desg3);
	    
	    List<Employee> empList = new ArrayList<Employee>();
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
	    	Employee emp = new Employee();
	    	emp.setEno(rs.getInt(1));
	    	emp.setEname(rs.getString(2));
	    	emp.setSal(rs.getFloat(3));
	    	
	    	empList.add(emp);
	    }
		return empList;
		
		
	}

	
}
