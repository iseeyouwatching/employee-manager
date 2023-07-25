package com.company.employeemanager.service;

import com.company.employeemanager.entity.Project;

public interface ValidationService {
    String NAME = "employeemanager_ValidationService";

    boolean isNameValid(Project project);

    boolean hasAssignedEmployees(Project project);
}