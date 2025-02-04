package com.ted.controller;


import com.ted.model.Employee;
import com.ted.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    //Inside Controller

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }


    @PostMapping("/employees")
   // @Valid  anotation for validating employee method argument
    public Employee createEmployee( @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id){
        return employeeService.findEmployeeById(id);
    }


    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }


    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean> > deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        Map<String,Boolean> response=new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }






}
