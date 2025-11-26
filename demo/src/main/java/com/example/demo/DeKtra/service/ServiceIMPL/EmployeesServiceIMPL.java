package com.example.demo.DeKtra.service.ServiceIMPL;

import com.example.demo.DeKtra.Repository.EmployeesRepository;
import com.example.demo.DeKtra.entity.Employees;

import com.example.demo.DeKtra.service.EmployeesService;
import com.example.demo.DeKtra.exception.CustomResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeesServiceIMPL implements EmployeesService {

    // Dependency Injection
    private final EmployeesRepository employeesRepository;

    @Override
    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees findById(long id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Employee not found for id: " + id));
    }

    @Override
    public Employees add(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public Employees update(Employees employeesDetails, long id) {

        return employeesRepository.findById(id).map(existingEmployee -> {
            if (employeesDetails.getName() != null) {
                existingEmployee.setName(employeesDetails.getName());
            }
            if (employeesDetails.getEmail() != null) {
                existingEmployee.setEmail(employeesDetails.getEmail());
            }
            if (employeesDetails.getSalary() != null) {
                existingEmployee.setSalary(employeesDetails.getSalary());
            }

            return employeesRepository.save(existingEmployee);

        }).orElseThrow(() -> new CustomResourceNotFoundException("Employee not found for update with id: " + id));
    }

    @Override
    public Employees delete(long id) {
        Employees deleteEmployee = findById(id);

        employeesRepository.deleteById(id);

        return deleteEmployee;
    }
}