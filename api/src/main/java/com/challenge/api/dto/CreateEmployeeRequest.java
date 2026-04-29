package com.challenge.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class CreateEmployeeRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Integer salary;

    @NotNull
    private Integer age;

    @NotBlank
    private String jobTitle;

    @NotBlank
    private String email;

    @NotNull
    private Instant contractHireDate;

    private Instant contractTerminationDate;
}
