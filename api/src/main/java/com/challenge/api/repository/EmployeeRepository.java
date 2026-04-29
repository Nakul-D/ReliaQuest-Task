package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeModel;
import java.time.Instant;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    // Acts as an in-memory database
    private final Map<UUID, Employee> database = new HashMap<>();

    // Enforces a unique constraint on email, similar to a database unique constraint
    private final Set<String> emailsInDB = new HashSet<>();

    public EmployeeRepository() {
        createMockEmployees();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Employee> findByUuid(UUID uuid) {
        return Optional.ofNullable(database.get(uuid));
    }

    public Employee save(Employee employee) {

        if (employee.getEmail() == null) {
            throw new IllegalArgumentException("Email is required");
        }

        employee.setEmail(employee.getEmail().toLowerCase());

        if (emailsInDB.contains(employee.getEmail())) {
            throw new IllegalArgumentException(("Email already in use"));
        }

        UUID uuid = UUID.randomUUID();
        employee.setUuid(uuid);
        database.put(uuid, employee);
        emailsInDB.add(employee.getEmail());
        return employee;
    }

    private void createMockEmployees() {
        EmployeeModel emp1 = new EmployeeModel();
        emp1.setFirstName("Steve");
        emp1.setLastName("Rogers");
        emp1.setAge(30);
        emp1.setJobTitle("Backend developer");
        emp1.setSalary(1400000);
        emp1.setEmail("steverogers@avengers.com");
        emp1.setContractHireDate(Instant.parse("2026-01-01T09:00:00Z"));
        save(emp1);

        EmployeeModel emp2 = new EmployeeModel();
        emp2.setFirstName("Bruce");
        emp2.setLastName("Banner");
        emp2.setAge(25);
        emp2.setJobTitle("Frontend Developer");
        emp2.setSalary(1200000);
        emp2.setEmail("brucebanner@avengers.com");
        emp2.setContractHireDate(Instant.parse("2026-01-01T09:00:00Z"));
        save(emp2);
    }
}
