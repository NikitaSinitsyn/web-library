package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));

    @Override
    public int getEmployeeCount() {
        return employeeList.size();
    }

    @Override
    public Double getTotalSalary() {

        return employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getMinSalaryEmployee() {
        Optional<Employee> minSalaryEmployee = employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
        return minSalaryEmployee.orElse(null);
    }

    @Override
    public Employee getMaxSalaryEmployee() {
        Optional<Employee> maxSalaryEmployee = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        return maxSalaryEmployee.orElse(null);
    }


    @Override
    public List<Employee> getHighSalaryEmployees() {
        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        return employeeList.stream()
                .filter(e -> e.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }

}


