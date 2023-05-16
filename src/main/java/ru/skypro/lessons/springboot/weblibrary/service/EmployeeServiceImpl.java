package ru.skypro.lessons.springboot.weblibrary.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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

    @Override
    public void createEmployees(@NonNull @Valid List<Employee> employees) {
            employeeRepository.createEmployees(employees);
    }
    @Override
    public void updateEmployeeByID(@Min(value = 1) int id, @NonNull @Valid Employee employee)  {
        if (!employeeRepository.exists(id)) {
            throw new IllegalArgumentException("Invalid employee id: " + id);
        }
        employeeRepository.updateEmployeeByID(id, employee);
    }
    @Override
    public Employee getEmployeeByID(int id) {
        if (!employeeRepository.exists(id)) {
            throw new IllegalArgumentException("Invalid employee id: " + id);
        }
        return employeeRepository.getEmployeeByID(id);
    }
    @Override
    public void deleteEmployeeByID(int id) {
        if (!employeeRepository.exists(id)) {
            throw new IllegalArgumentException("Invalid employee id: " + id);
        }
        employeeRepository.deleteEmployeeByID(id);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(double salary) {
        return employeeRepository.getEmployeesWithSalaryHigherThan(salary);
    }
}
