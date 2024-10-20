package com.vatsaladhiya.apidev.apidev.controllers;

import com.vatsaladhiya.apidev.apidev.dto.EmployeeDTO;
import com.vatsaladhiya.apidev.apidev.entities.EmployeeEntity;
import com.vatsaladhiya.apidev.apidev.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
//    @GetMapping(path = "/getMessage")
//    public String getMessage() {
//        return "Secret Message: Hello";
//    }
    private final EmployeeRepository employeeRepository;

    public EmployeeController (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById (@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
}
