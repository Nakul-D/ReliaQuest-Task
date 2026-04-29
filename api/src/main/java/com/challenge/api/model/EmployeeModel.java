package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
public class EmployeeModel implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    @Override
    public String getFullName() {
        String fullName = "";
        if (firstName != null && !firstName.isBlank()) {
            fullName += firstName;

            if (lastName != null && !lastName.isBlank()) {
                fullName += " " + lastName;
            }
        }

        return fullName.isBlank() ? null : fullName;
    }

    @Override
    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }
        String[] parts = fullName.split(" ", 2);
        this.firstName = parts[0];
        this.lastName = parts.length > 1 ? parts[1] : null;
    }
}
