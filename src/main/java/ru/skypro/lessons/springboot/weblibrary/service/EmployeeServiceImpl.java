package ru.skypro.lessons.springboot.weblibrary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public int getEmployeeCount() {
        return employeeRepository.getEmployeeCount();
    }

    @Override
    public Double getTotalSalary() {
        return employeeRepository.getTotalSalary();
    }

    @Override
    public Employee getMinSalaryEmployee() {
        return employeeRepository.getMinSalaryEmployee();
    }

    @Override
    public Employee getMaxSalaryEmployee() {
        return employeeRepository.getMaxSalaryEmployee();
    }

    @Override
    public List<Employee> getHighSalaryEmployees() {
        return employeeRepository.getHighSalaryEmployees();
    }
}
