package com.company.employeemanager.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "EMPLOYEEMANAGER_EMPLOYEE")
@Entity(name = "employeemanager_Employee")
@NamePattern("%s|fullName")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = -6396769517175040280L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}