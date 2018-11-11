package com.macnis.developer.WFH.service;

import com.macnis.developer.WFH.domain.Employee;
import com.macnis.developer.WFH.repository.EmployeeRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GraphQLQuery(name = "employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GraphQLQuery(name = "employee")
    public Optional<Employee> getEmployeeById(@GraphQLArgument(name = "id") Long id){
        return employeeRepository.findById(id);
    }

    @GraphQLMutation(name = "saveEmployee")
    public Employee saveEmployee(@GraphQLArgument(name = "employee") Employee employee){
        return employeeRepository.save(employee);
    }

    @GraphQLMutation(name = "deleteEmployee")
    public void deleteEmployee(@GraphQLArgument(name = "id") Long id){
        employeeRepository.deleteById(id);
    }
}
