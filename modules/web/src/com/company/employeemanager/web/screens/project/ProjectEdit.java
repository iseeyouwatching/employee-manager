package com.company.employeemanager.web.screens.project;

import com.company.employeemanager.entity.Employee;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.employeemanager.entity.Project;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;

@UiController("employeemanager_Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
@LoadDataBeforeShow
public class ProjectEdit extends StandardEditor<Project> {

    @Inject
    private InstanceContainer<Project> projectDc;

    @Inject
    private UiComponents uiComponents;

    public Component generateCheckBox(Employee employee) {
        CheckBox checkBox = uiComponents.create(CheckBox.class);
        Project editedProject = projectDc.getItem();
        checkBox.setValue(editedProject.getEmployees().contains(employee));
        checkBox.addValueChangeListener(e -> {
            if (Boolean.TRUE.equals(e.getValue())) {
                editedProject.getEmployees().add(employee);
            } else {
                editedProject.getEmployees().remove(employee);
            }
        });
        return checkBox;
    }

}