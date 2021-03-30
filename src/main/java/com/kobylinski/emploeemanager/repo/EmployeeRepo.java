package com.kobylinski.emploeemanager.repo;

import com.kobylinski.emploeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmploeeById(Long id);

    void deleteEmployeeById(Long id);
}
