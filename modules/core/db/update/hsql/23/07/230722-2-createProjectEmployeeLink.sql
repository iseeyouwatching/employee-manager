alter table PROJECT_EMPLOYEE_LINK add constraint FK_PROEMP_ON_PROJECT foreign key (PROJECT_ID) references EMPLOYEEMANAGER_PROJECT(ID);
alter table PROJECT_EMPLOYEE_LINK add constraint FK_PROEMP_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references EMPLOYEEMANAGER_EMPLOYEE(ID);