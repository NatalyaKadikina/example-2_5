package com.sky.pro.application.service;

import com.sky.pro.application.exception.EmployeeAlreadyAddedException;
import com.sky.pro.application.exception.EmployeeNotFoundException;
import com.sky.pro.application.exception.EmployeeStorageIsFullException;
import com.sky.pro.application.exception.InvalidlnputException;
import com.sky.pro.application.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();
    private int maxList = 15;

    public EmployeeService() {
        employees.put(new Employee("Ivanov", "Ivan").getFullName(), new Employee("Ivanov", "Ivan"));
        employees.put(new Employee("Ivanov2", "Ivan2").getFullName(), new Employee("Ivanov2", "Ivan2"));
        employees.put(new Employee("Ivanov3", "Ivan3").getFullName(), new Employee("Ivanov3", "Ivan3"));
        employees.put(new Employee("Ivanov4", "Ivan4").getFullName(), new Employee("Ivanov4", "Ivan4"));
        employees.put(new Employee("Ivanov5", "Ivan5").getFullName(), new Employee("Ivanov5", "Ivan5"));
        employees.put(new Employee("Ivanov6", "Ivan6").getFullName(), new Employee("Ivanov6", "Ivan6"));
        employees.put(new Employee("Ivanov7", "Ivan7").getFullName(), new Employee("Ivanov7", "Ivan7"));
        employees.put(new Employee("Ivanov8", "Ivan8").getFullName(), new Employee("Ivanov8", "Ivan8"));
        employees.put(new Employee("Ivanov9", "Ivan9").getFullName(), new Employee("Ivanov9", "Ivan9"));
        employees.put(new Employee("Ivanov10", "Ivan10").getFullName(), new Employee("Ivanov10", "Ivan10"));
    }

    public Collection<Employee> All() {
        return employees.values();
    }

    public Employee Add(String firstName, String lastName) {

        if (!validateInput (firstName, lastName)) {
            throw new InvalidlnputException();
        }

        Employee newEmployee = new Employee(lastName, firstName);
        if(employees.containsKey(newEmployee.getFullName()))
            throw new EmployeeAlreadyAddedException("Такой сотрудник есть");
        if(employees.size() + 1 > maxList)
            throw new EmployeeStorageIsFullException("Массив переполнен");

        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    public Employee Remove(String firstName, String lastName) {

        if (!validateInput (firstName, lastName)) {
            throw new InvalidlnputException();
        }

        Employee removeEmployee = new Employee(lastName,firstName);
        if(employees.containsKey(removeEmployee.getFullName()))
            employees.remove(removeEmployee.getFullName());
        else
            throw new EmployeeNotFoundException("Не найден работник");
        return removeEmployee;
    }

    public Employee Find(String firstName, String lastName) {

        if (!validateInput (firstName, lastName)) {
            throw new InvalidlnputException();
        }

        Employee findEmployee = new Employee(lastName, firstName);
        if(!employees.containsKey(findEmployee))
            throw new EmployeeNotFoundException("Не найден работник");

        return findEmployee;
    }

    private boolean validateInput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}
