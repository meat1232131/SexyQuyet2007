package com.example.demo.DeKtra.service;

import com.example.demo.DeKtra.entity.Employees;

import java.util.List;

public interface EmployeesService {
    List<Employees> findAll();
    Employees findById(long id);
    Employees add(Employees employees);
    Employees update(Employees employees, long id);
    Employees delete(long id);
}
