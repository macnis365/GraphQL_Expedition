package com.macnis.developer.WFH;

import com.macnis.developer.WFH.domain.Employee;
import com.macnis.developer.WFH.service.EmployeeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class WfhApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfhApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EmployeeService employeeService){
		return args -> {
			Stream.of("Augustine Nishil Raj", "Micheal John").forEach(name->{
				Employee employee = new Employee();
				employee.setName(name);
				employeeService.saveEmployee(employee);
			});
			employeeService.getEmployees().forEach(System.out::println);
		};
	}
}
