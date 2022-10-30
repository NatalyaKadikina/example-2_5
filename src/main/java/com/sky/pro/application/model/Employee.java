package com.sky.pro.application.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee (String lastName, String firstName) {
        this.lastName = capitalize(lastName.toLowerCase(Locale.ROOT));
        this.firstName = capitalize(firstName.toLowerCase(Locale.ROOT));
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

