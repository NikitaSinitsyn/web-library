package ru.skypro.lessons.springboot.weblibrary.repository;

import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee(1, "Катя", 90_000),
            new Employee(2, "Дима", 102_000),
            new Employee(3, "Олег", 80_000),
            new Employee(4, "Вика", 165_000));

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

    @Override
    public void createEmployees( @NonNull @Valid List<Employee> employees) {
        employeeList.addAll(employees);
    }


    @Override
    public void updateEmployeeByID(@Min(value = 1) int id, @NonNull @Valid Employee employee) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();

        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            emp.setName(employee.getName());
            emp.setSalary(employee.getSalary());
        } else {
            throw new IllegalArgumentException("Employee with ID " + id + " not found");
        }
    }
    @Override
    public Employee getEmployeeByID(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void deleteEmployeeByID(int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(double salary) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(int id) {
        return employeeList.stream()
                .anyMatch(employee -> employee.getId() == id);
    }

}


