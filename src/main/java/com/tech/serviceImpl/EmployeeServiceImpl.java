package com.tech.serviceImpl;

import com.tech.dto.CreateEmployeeRequest;
import com.tech.dto.EmployeeConvert;
import com.tech.dto.EmployeeDto;
import com.tech.dto.UpdateEmployeeRequest;
import com.tech.exception.EmployeeNotFoundException;
import com.tech.model.Employee;
import com.tech.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;





    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee createEmployee(Employee employee) {
         Employee employee1=new Employee();
         employee1.setName( employee.getName());
         employee1.setSurname( employee.getSurname());
         employee1.setEmail( employee.getEmail());
         employee1.setAge(employee.getAge());
         employee1.setDepartment( employee.getDepartment());
         employee1.setPosition( employee.getPosition());
         employee1.setSalary( employee.getSalary());

         return employeeRepository.save(employee1);

    }


    public Employee updateEmployee(String email,Employee employee ) {
        Employee employeeId=getByEmail(email);

        employeeId.setName(employee.getName());
        employeeId.setSurname(employee.getSurname());
        employeeId.setEmail(employee.getEmail());
        employeeId.setAge(employee.getAge());
        employeeId.setPosition(employee.getPosition());
        employeeId.setDepartment(employee.getDepartment());
        employeeId.setSalary(employee.getSalary());

        return employeeRepository.save(employeeId);
    }


    public void deleteEmployeeById(Long id) {
       employeeRepository.deleteById(id);
    }





    public Employee getByEmail(String email) {
       return  employeeRepository.findByEmail(email);
    }








}
