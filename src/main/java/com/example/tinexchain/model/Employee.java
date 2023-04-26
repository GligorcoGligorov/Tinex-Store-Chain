package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Long employee_Id;

    private String employee_name;
    private String employee_surname;


    public Employee() {

    }

    public Long getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(Long employee_Id) {
        this.employee_Id = employee_Id;
    }

    public Employee(Long employee_Id, String employee_name, String employee_surname) {
        this.employee_Id = employee_Id;
        this.employee_name = employee_name;
        this.employee_surname = employee_surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_Id=" + employee_Id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_surname='" + employee_surname + '\'' +
                '}';
    }
}
