package in.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.dao.EmployeeDAOImpl;
import in.spring.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeDAOImpl daoImpl;
	
	@Override
	public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> empList = daoImpl.getEmployeeByDesg(desg1, desg2, desg3);
				
		return empList;
	}

}
