package com.company.employeemanager.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.employeemanager.entity.Employee;

@UiController("employeemanager_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}