package com.spingboot.demo.DAO;

import com.spingboot.demo.Entity.EmployeeEntity;
import com.spingboot.demo.Entity.EmployeeUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class EmployeesDAO {
    @Autowired

    private EmployeeRepository repository;

    public Collection<EmployeeEntity> getEmployees() {
        return repository.findAll();
    }

    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return repository.insert(employee);
    }

    public Optional<EmployeeEntity> getEmployeeById(String id) {
        return repository.findById(id);
    }
    public Optional<EmployeeEntity> deleteEmployeeById(String id) {
        Optional<EmployeeEntity> employees = repository.findById(id);
        employees.ifPresent(employees1 -> repository.delete(employees1));
        return employees;
    }

    public Optional<EmployeeEntity> updateEmployeeById(String id, EmployeeUpdatePayload employeeUpdatePayload) {
        Optional<EmployeeEntity> employees = repository.findById(id);
        employees.ifPresent(employees1 -> employees1.setName(employeeUpdatePayload.getName()));
        employees.ifPresent(employees1 -> employees1.setOffice(employeeUpdatePayload.getOffice()));
        employees.ifPresent(employees1 -> employees1.setSalary(employeeUpdatePayload.getSalary()));
        employees.ifPresent(employees1 -> employees1.setPosition(employeeUpdatePayload.getPosition()));
        employees.ifPresent(employees1 -> repository.save(employees1));
        return employees;
    }
}

