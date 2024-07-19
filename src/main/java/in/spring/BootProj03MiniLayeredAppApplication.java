package in.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.spring.controller.MainController;
import in.spring.model.Employee;

@SpringBootApplication
public class BootProj03MiniLayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniLayeredAppApplication.class, args);
		MainController controller = ctx.getBean("controller", MainController.class);
		
		try {
		List<Employee> empList =  controller.gatherEmpByDesg("CLERK", "ANALYST", "PRESIDENT");
			
		empList.forEach(emp->{
			System.out.println(emp);
		});
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
