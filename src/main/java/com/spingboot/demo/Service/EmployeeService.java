package com.spingboot.demo.Service;

import com.spingboot.demo.DAO.EmployeesDAO;
import com.spingboot.demo.Entity.EmployeeEntity;
import com.spingboot.demo.Entity.EmployeeUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeesDAO employeesDAO;
    public Collection<EmployeeEntity> getEmployees() {
        return employeesDAO.getEmployees();
    }

    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeesDAO.createEmployee(employee);
    }

    public Optional<EmployeeEntity> getEmployeeById(String id) {
        return employeesDAO.getEmployeeById(id);
    }

    public Optional<EmployeeEntity> deleteEmployeeById(String id) {
        return employeesDAO.deleteEmployeeById(id);
    }

    public Optional<EmployeeEntity> updateEmployeeById(String id, EmployeeUpdatePayload employeeUpdatePayload) {
        return employeesDAO.updateEmployeeById(id, employeeUpdatePayload);
    }
}
