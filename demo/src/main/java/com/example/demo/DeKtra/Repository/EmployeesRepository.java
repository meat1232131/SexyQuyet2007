package com.example.demo.DeKtra.Repository;

import com.example.demo.DeKtra.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}

