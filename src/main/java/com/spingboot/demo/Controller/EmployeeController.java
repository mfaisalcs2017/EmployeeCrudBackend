package com.spingboot.demo.Controller;

import com.spingboot.demo.Entity.EmployeeEntity;
import com.spingboot.demo.Entity.EmployeeUpdatePayload;
import com.spingboot.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Collection<EmployeeEntity> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeEntity createEmployees(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = "/{id}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<EmployeeEntity> deleteEmployeeById(@PathVariable("id") int id) {
        return employeeService.deleteEmployeeById(id);
    }
    @PutMapping(value = "/{id}")
    public Optional<EmployeeEntity> updateEmployeeById(@PathVariable("id") int id, @RequestBody EmployeeUpdatePayload employeeUpdatePayload) {
        return employeeService.updateEmployeeById(id, employeeUpdatePayload);
    }
}

