package com.vatsaladhiya.apidev.apidev.controllers;

import com.vatsaladhiya.apidev.apidev.dto.DepartmentDTO;
import com.vatsaladhiya.apidev.apidev.exceptions.ResourceNotFoundException;
import com.vatsaladhiya.apidev.apidev.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        DepartmentDTO newDepartmentDTO = new DepartmentDTO(departmentDTO.getTitle(), departmentDTO.getIsActive());
        DepartmentDTO savedDepartmentDTO = departmentService.createNewDepartment(newDepartmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        DepartmentDTO newDepartmentDTO = new DepartmentDTO(departmentDTO.getTitle(), departmentDTO.getIsActive());
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId, newDepartmentDTO));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if (gotDeleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(departmentId);
        return departmentDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
    }
}
