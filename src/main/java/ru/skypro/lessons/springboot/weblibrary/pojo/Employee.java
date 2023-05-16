package ru.skypro.lessons.springboot.weblibrary.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @NonNull()
    private int id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @Min(value = 0, message = "Salary must be a positive number")
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
