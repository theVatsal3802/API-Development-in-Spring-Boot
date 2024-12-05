package com.vatsaladhiya.apidev.apidev.controllers;

import com.vatsaladhiya.apidev.apidev.dto.EmployeeDTO;
import com.vatsaladhiya.apidev.apidev.entities.EmployeeEntity;
import com.vatsaladhiya.apidev.apidev.repositories.EmployeeRepository;
import com.vatsaladhiya.apidev.apidev.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/")
//    public String getMySuperSecretMessage() {
//        return "Hello";
//    }
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.createNewEmployee(employee);
    }
}
