package com.ted.service;

import com.ted.exception.ResourceNotFoundException;

import com.ted.model.Employee;
import com.ted.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Found with id: "+id));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee  =employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Found with id: "+id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
//          existingEmployee.builder().firstName(employee.getFirstName())
//                  .lastName(employee.getLastName())
//                  .email(employee.getEmail()).build();
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee existingEmployee  =employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Found with id: "+id));
        employeeRepository.delete(existingEmployee);
    }
}
