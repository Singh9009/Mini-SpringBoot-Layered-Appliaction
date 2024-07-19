package in.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.spring.model.Employee;
import in.spring.service.EmployeeMgmtServiceImpl;

@Controller("controller")
public class MainController {

	@Autowired
	private EmployeeMgmtServiceImpl service;
	
	public List<Employee> gatherEmpByDesg(String desg1, String desg2, String desg3)throws Exception
	{
		List<Employee> empList = service.fetchEmployeeByDesg(desg1, desg2, desg3);
		return empList;
	}
}
