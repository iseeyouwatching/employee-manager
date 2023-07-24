-- begin EMPLOYEEMANAGER_EMPLOYEE
create table EMPLOYEEMANAGER_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end EMPLOYEEMANAGER_EMPLOYEE
-- begin EMPLOYEEMANAGER_PROJECT
create table EMPLOYEEMANAGER_PROJECT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end EMPLOYEEMANAGER_PROJECT
-- begin PROJECT_EMPLOYEE_LINK
create table PROJECT_EMPLOYEE_LINK (
    PROJECT_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (PROJECT_ID, EMPLOYEE_ID)
)^
-- end PROJECT_EMPLOYEE_LINK
