package com.company.employeemanager.service;

import com.company.employeemanager.entity.Employee;
import com.company.employeemanager.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(ValidationService.NAME)
public class ValidationServiceBean implements ValidationService {

    @Override
    public boolean isNameValid(Project project) {
        return project.getName() != null && !project.getName().isEmpty();
    }

    @Override
    public boolean hasAssignedEmployees(Project project) {
        List<Employee> employees = project.getEmployees();
        return !employees.isEmpty();
    }

}