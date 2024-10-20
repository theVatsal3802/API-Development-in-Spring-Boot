package com.vatsaladhiya.apidev.apidev.repositories;

import com.vatsaladhiya.apidev.apidev.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
