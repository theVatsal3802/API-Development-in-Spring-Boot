package com.vatsaladhiya.apidev.apidev.repositories;

import com.vatsaladhiya.apidev.apidev.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}

