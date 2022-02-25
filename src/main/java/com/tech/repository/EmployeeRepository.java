package com.tech.repository;

import com.tech.dto.EmployeeDto;
import com.tech.model.Employee;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

//  Employee findByName(String name);
//  Employee findBySurname(String surname);
//  Employee findByAge(String age);
//  Employee findByDepartment(String department);
//  Employee findByPosition(String position);
//  Employee findBySalary(String salary);
  Employee findByEmail(String email);
}
