package com.example.demo.DeKtra.controller;


import com.example.demo.DeKtra.entity.Employees;
import com.example.demo.DeKtra.service.EmployeesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    @GetMapping()
    public ResponseEntity<List<Employees>> getAllEmployees(){
        List<Employees> employees = employeesService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employees> getEmployeeByID(@PathVariable("id") long id){
        Employees employee = employeesService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employees> addEmployee(@Valid @RequestBody Employees employee) {
        Employees savedEmployee = employeesService.add(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@Valid @RequestBody Employees employee, @PathVariable("id") long id) {
        Employees updatedEmployee = employeesService.update(employee, id);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
//        employeesService.delete(id);
//        return new ResponseEntity<>("Employee with ID " + id + " deleted successfully.", HttpStatus.OK);
//    }

    //This is a comment for testing git branch : no delete mapping
}
