package com.mahmoudh.dmsproject.service;

import com.mahmoudh.dmsproject.model.Employee;
import com.mahmoudh.dmsproject.repository.EmployeeRepo;

import java.util.List;


public class EmployeeService {
    EmployeeRepo employeeRepo;
    private static EmployeeService instance;

    private EmployeeService() {
        employeeRepo = EmployeeRepo.getInstance();
    }

    //singleton pattern
    public static EmployeeService getInstance() {
        if (instance == null) {
            instance = new EmployeeService();
        }
        return instance;
    }

    public void save(Employee emp) {
        employeeRepo.saveNewEmployee(emp);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepo.getAllEmployee();
    }

    public boolean isCodeUsed(String code) {
        return employeeRepo.getEmployeeByCode(code).size() > 0;
    }

    public void updateEmployee(Employee emp) {
        employeeRepo.updateEmployee(emp);
    }

    public void deleteEmployee(Employee emp) {
        employeeRepo.deleteEmployee(emp);
    }

}