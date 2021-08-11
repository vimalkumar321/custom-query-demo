package com.vimal.demo.customquerydemo.service;

import com.vimal.demo.customquerydemo.model.Employee;
import com.vimal.demo.customquerydemo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){

        this.employeeRepository=employeeRepository;
    }

    public ResponseEntity<Object> createEmployee(Employee model) {

        Employee employee = new Employee();
        if(employeeRepository.findByEmail(model.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
        }
        else {
            employee.setName(model.getName());
            employee.setDob(model.getDob());
            employee.setMobile(model.getMobile());
            employee.setSalary(model.getSalary());
            employee.setEmail(model.getEmail());
            employee.setPassword(model.getPassword());
            Employee savedEmployee = employeeRepository.save(employee);
            if(employeeRepository.findById(savedEmployee.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else
                return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
    }

}
