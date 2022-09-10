package com.employeecrudop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name="EmployeeInfo")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private String empAddress;
    private long empSalary;

    public Employee(int empId, String empName, String empAddress, long empSalary) {
    }

    public Employee() {

    }
}
