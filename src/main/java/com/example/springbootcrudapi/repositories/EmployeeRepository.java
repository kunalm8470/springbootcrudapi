package com.example.springbootcrudapi.repositories;

import com.example.springbootcrudapi.entities.Employees;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employees, String> {
}
