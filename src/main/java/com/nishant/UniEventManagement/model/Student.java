package com.nishant.UniEventManagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private Integer studentId;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "First letter must be uppercase")
    private String firstName;

    @NotBlank
    private String lastName;

    @Max(value = 25, message = "Age must be smaller than 25")
    @Min(value = 18, message = "Age must be greater than 18")
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Department department;
}
