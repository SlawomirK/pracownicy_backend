package com.kobylinski.emploeemanager.service;

import com.kobylinski.emploeemanager.exception.UserNotFoundException;
import com.kobylinski.emploeemanager.model.Employee;
import com.kobylinski.emploeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
    employee.setEmployCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
    return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
    return employeeRepo.findEmploeeById(id).orElseThrow(()->new UserNotFoundException("User by id "+id+"was not found"));
    }
    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }
}
