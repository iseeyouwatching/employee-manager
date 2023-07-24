package com.company.employeemanager.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.employeemanager.entity.Employee;

@UiController("employeemanager_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}