package com.example.springbootcrudapi.services.impl;

import com.example.springbootcrudapi.dto.EmployeeDto;
import com.example.springbootcrudapi.entities.Employees;
import com.example.springbootcrudapi.repositories.EmployeeRepository;
import com.example.springbootcrudapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public EmployeeDto getEmployeeById(String id) {
        Employees employee = employeeRepository.findById(id).get();

        return convertToDto(employee);
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @return
     */
    @Override
    public EmployeeDto createEmployee(String firstName, String lastName, String email) {
        Employees employee = new Employees(firstName, lastName, email);

        return convertToDto(employeeRepository.save(employee));
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        Iterable<Employees> employees = employeeRepository.findAll();

        return StreamSupport.stream(employees.spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     */
    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDto convertToDto(Employees employee){
        if (employee == null) {
            return null;
        }

        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());

        return dto;
    }
}
