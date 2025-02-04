package com.ted.service;



import com.ted.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee createEmployee(Employee employee);

    Employee findEmployeeById(long id);

    Employee updateEmployee(long id,Employee employee);

    void deleteEmployee(long id);

}
