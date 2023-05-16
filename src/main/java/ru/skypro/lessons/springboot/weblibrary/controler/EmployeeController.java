package ru.skypro.lessons.springboot.weblibrary.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/count")
    public int getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }

    @GetMapping("/salary/sum")
    public Double getTotalSalary() {
        return employeeService.getTotalSalary();
    }

    @GetMapping("/salary/min")
    public Employee getMinSalaryEmployee() {
        return employeeService.getMinSalaryEmployee();
    }

    @GetMapping("/salary/max")
    public Employee getMaxSalaryEmployee() {
        return employeeService.getMaxSalaryEmployee();
    }

    @GetMapping("/salary/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        return employeeService.getHighSalaryEmployees();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployees(@RequestBody List<Employee> employees) {
        employeeService.createEmployees(employees);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody @Valid Employee employee) {
        employeeService.updateEmployeeByID(id, employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeByID(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") double salary) {
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }






   /* ### Получение суммы зарплат сотрудников
    GET http://localhost:8080/employee/salary/sum

            ### Получение сотрудника с минимальной зарплатой
    GET http://localhost:8080/employee/salary/min

            ### Получение сотрудника с максимальной зарплатой
    GET http://localhost:8080/employee/salary/max

            ### Получение всех сотрудников, зарплата которых больше средней
    GET http://localhost:8080/employee/high-salary */

}
