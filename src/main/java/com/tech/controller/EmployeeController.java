package com.tech.controller;
import com.tech.model.Employee;
import com.tech.repository.EmployeeRepository;
import com.tech.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private EmployeeRepository employeeRepository;






    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeServiceImpl.getAllEmployee());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Employee> getByEmail(@PathVariable ("email") String email){
        return ResponseEntity.ok(employeeRepository.findByEmail(email));
    }


    @PostMapping()
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee ){
        return ResponseEntity.ok(employeeServiceImpl.createEmployee(employee));
    }

    @PutMapping("/{email}")
    public ResponseEntity<Employee>updateEmployee(
            @PathVariable String email,
            @RequestBody Employee employee){
       Employee employee1=employeeServiceImpl.getByEmail(email);
       employeeServiceImpl.updateEmployee(email,employee);
       return  new ResponseEntity<>(HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable("id") Long id){
        employeeServiceImpl.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    





}
