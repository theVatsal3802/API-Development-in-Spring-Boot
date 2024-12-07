package com.vatsaladhiya.apidev.apidev.services;

import com.vatsaladhiya.apidev.apidev.dto.DepartmentDTO;
import com.vatsaladhiya.apidev.apidev.entities.DepartmentEntity;
import com.vatsaladhiya.apidev.apidev.exceptions.ResourceNotFoundException;
import com.vatsaladhiya.apidev.apidev.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity toSaveEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO departmentDTO) {
        checkIfDepartmentExists(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        checkIfDepartmentExists(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    private void checkIfDepartmentExists(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) {
            throw new ResourceNotFoundException("Department not found");
        }
    }

    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {
        return departmentRepository
                .findById(departmentId)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }
}
