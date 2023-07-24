package com.company.employeemanager.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Table(name = "EMPLOYEEMANAGER_PROJECT")
@Entity(name = "employeemanager_Project")
@NamePattern("%s|name")
public class Project extends StandardEntity {
    private static final long serialVersionUID = 8807354488083823379L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinTable(name = "PROJECT_EMPLOYEE_LINK",
            joinColumns = @JoinColumn(name = "PROJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @ManyToMany
    @MetaProperty(related = "employees")
    private List<Employee> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}