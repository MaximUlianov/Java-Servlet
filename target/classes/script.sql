drop table if exists ief.employee;
create table ief.employee (id INT NOT NULL AUTO_INCREMENT,first_name VARCHAR(45) NULL,last_name VARCHAR(45) NULL,designation VARCHAR(45) NULL,phone_number VARCHAR(45) NULL,PRIMARY KEY (id));
insert into ief.employee values (1, 'Ivan', 'Ivanov', 'Manager', '11-22-33');
insert into ief.employee values (2, 'Nikolay', 'Ivanov', 'Programmer', '33-44-55');
insert into ief.employee values (3, 'Sergey', 'Petrov', 'System administrator', '12-34-56');
insert into ief.employee values (4, 'Alexey', 'Petrov', 'Manager', '56-78-90');
insert into ief.employee values (5, 'Vitaliy', 'Kuznetsov', 'Technician', '55-66-77');