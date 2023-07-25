package com.company.employeemanager.web.screens.project;

import com.company.employeemanager.entity.Employee;
import com.company.employeemanager.service.ValidationService;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.employeemanager.entity.Project;
import com.haulmont.cuba.gui.Notifications;

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

    @Inject
    private ValidationService validationService;

    @Inject
    private Notifications notifications;

    @Subscribe("commitAndCloseBtn")
    protected void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        Project project = getEditedEntity();

        if (!validationService.isNameValid(project)) {
            notifications.create()
                    .withCaption("У проекта обязательно должно быть название.")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
    }

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Project project = getEditedEntity();

        if (!validationService.hasAssignedEmployees(project)) {
            event.preventCommit();
            notifications.create()
                    .withCaption("У проекта обязательно должен быть хотя бы один сотрудник.")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
    }

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