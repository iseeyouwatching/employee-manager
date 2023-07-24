package com.company.employeemanager.web.screens.project;

import com.haulmont.cuba.gui.screen.*;
import com.company.employeemanager.entity.Project;

@UiController("employeemanager_Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
@LoadDataBeforeShow
public class ProjectBrowse extends StandardLookup<Project> {
}