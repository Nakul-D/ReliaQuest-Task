package com.challenge.api.service;

import com.challenge.api.dto.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeModel;
import com.challenge.api.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        Optional<Employee> employee = employeeRepository.findByUuid(uuid);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new IllegalArgumentException("Employee not found");
    }

    public Employee createEmployee(CreateEmployeeRequest request) {

        EmployeeModel newEmployee = new EmployeeModel();
        newEmployee.setFirstName(request.getFirstName());
        newEmployee.setLastName(request.getLastName());
        newEmployee.setSalary(request.getSalary());
        newEmployee.setAge(request.getAge());
        newEmployee.setJobTitle(request.getJobTitle());
        newEmployee.setEmail(request.getEmail());
        newEmployee.setContractHireDate(request.getContractHireDate());
        newEmployee.setContractTerminationDate(request.getContractTerminationDate());

        return employeeRepository.save(newEmployee);
    }
}
