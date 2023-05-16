package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    int getEmployeeCount();
    Double getTotalSalary();
    Employee getMinSalaryEmployee();
    Employee getMaxSalaryEmployee();
    List<Employee> getHighSalaryEmployees();
    void createEmployees(List<Employee> employees);
    void updateEmployeeByID(int id, Employee employee);
    Employee getEmployeeByID(int id);
    void deleteEmployeeByID(int id);
    List<Employee> getEmployeesWithSalaryHigherThan(double salary);

}
