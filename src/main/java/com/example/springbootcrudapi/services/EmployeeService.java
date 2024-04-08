package com.example.springbootcrudapi.services;

import com.example.springbootcrudapi.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getEmployeeById(String id);

    EmployeeDto createEmployee(String firstName, String lastName, String email);

    List<EmployeeDto> getAllEmployees();

    void deleteEmployeeById(String id);
}
