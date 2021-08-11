package com.vimal.demo.customquerydemo.controller;

import com.vimal.demo.customquerydemo.model.Employee;
import com.vimal.demo.customquerydemo.repository.EmployeeRepository;
import com.vimal.demo.customquerydemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService){
        this.employeeRepository=employeeRepository;
        this.employeeService=employeeService;
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employee/all")
    public List<Employee> getEmployees(){

        return (List<Employee>)employeeRepository.findAll();
    }

    @GetMapping("/employee/details/{id}")
    public Employee getEmployee(@PathVariable  Long id){
        if(employeeRepository.findById(id).isPresent())
        return employeeRepository.findById(id).get();
        else return  null;
    }

    @GetMapping("/employee/fetch/{email}")
    public Employee getEmployee(@PathVariable String email){
        if(employeeRepository.findByEmail(email).isPresent())
            return employeeRepository.findByEmail(email).get();
        else return null;
    }

    @GetMapping("/employee/get/email/{email}/{password}")
    public Employee getEmployeeByEmailAndPassword(@PathVariable String email,@PathVariable String password){
            if(employeeRepository.findByEmailAndPassword(email,password).isPresent())
                return employeeRepository.findByEmailAndPassword(email,password).get();
            else return null;
    }

    @GetMapping("employee/get/salary/{s}/{e}")
    public List<Employee> getEmployeeByAgeBetween(@PathVariable Long s,@PathVariable Long e){
        List<Employee> list = employeeRepository.findBySalaryBetween(s,e);
        if(list.size()>0)
            return list;
        return null;
    }
}
