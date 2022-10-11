package com.sky.pro.application.service;

import com.sky.pro.application.exception.EmployeeAlreadyAddedException;
import com.sky.pro.application.exception.EmployeeNotFoundException;
import com.sky.pro.application.exception.EmployeeStorageIsFullException;
import com.sky.pro.application.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<Employee>();
    private int maxList = 15;

    public EmployeeService() {
        employees.add(new Employee("Ivanov", "Ivan"));
        employees.add(new Employee("Ivanov2", "Ivan2"));
        employees.add(new Employee("Ivanov3", "Ivan3"));
        employees.add(new Employee("Ivanov4", "Ivan4"));
        employees.add(new Employee("Ivanov5", "Ivan5"));
        employees.add(new Employee("Ivanov6", "Ivan6"));
        employees.add(new Employee("Ivanov7", "Ivan7"));
        employees.add( new Employee("Ivanov8", "Ivan8"));
        employees.add(new Employee("Ivanov9", "Ivan9"));
        employees.add(new Employee("Ivanov10", "Ivan10"));
    }

    public List<Employee> All() {
        return employees;
    }

    public boolean Add(String firstName, String lastName) {
        Employee newEmployee = new Employee(lastName, firstName);
        if(employees.contains(newEmployee))
            throw new EmployeeAlreadyAddedException("Такой сотрудник есть");
        if(employees.size() + 1 > maxList)
            throw new EmployeeStorageIsFullException("Массив переполнен");

        employees.add(newEmployee);
        return true;
    }

    public boolean Remove(String firstName, String lastName) {

        Employee removeEmployee = new Employee(lastName,firstName);
        if(employees.remove(removeEmployee))
            return true;

        throw new EmployeeNotFoundException("Не найден работник");
    }

    public boolean Find(String firstName, String lastName) {

        Employee findEmployee = new Employee(lastName, firstName);
        if(!employees.contains(findEmployee))
            throw new EmployeeNotFoundException("Не найден работник");

        return true;
    }
}
