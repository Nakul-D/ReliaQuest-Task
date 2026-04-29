package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepository {

    // Acts as an in-memory database
    private final Map<UUID, Employee> database = new HashMap<>();

    // Enforces a unique constraint on email, similar to a database unique constraint
    private final Set<String> emailsInDB = new HashSet<>();

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
}
