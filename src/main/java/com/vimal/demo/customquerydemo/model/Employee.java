package com.vimal.demo.customquerydemo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(unique = true, length = 10)
    private String mobile;
    private Long salary;
    @Column(unique = true)
    private String email;
    private String password;

    public Employee(){}

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Date getDob() {

        return dob;
    }

    public void setDob(Date dob) {

        this.dob = dob;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public Long getSalary() {

        return salary;
    }

    public void setSalary(Long salary) {

        this.salary = salary;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
