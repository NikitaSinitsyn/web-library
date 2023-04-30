package ru.skypro.lessons.springboot.weblibrary.repository;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    int getEmployeeCount();
    Double getTotalSalary();
    Employee getMinSalaryEmployee();
    Employee getMaxSalaryEmployee();
    List<Employee> getHighSalaryEmployees();
}
