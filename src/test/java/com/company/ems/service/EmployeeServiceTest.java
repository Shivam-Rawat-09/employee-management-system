package com.company.ems.service;

import com.company.ems.model.Employee;
import com.company.ems.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setEmployeeId("EMP001");
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setDepartmentId(1L);
        employee.setPosition("Software Engineer");
        employee.setSalary(60000.00);
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee createdEmployee = employeeService.createEmployee(employee);
        assertNotNull(createdEmployee);
        assertEquals("John", createdEmployee.getFirstName());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Employee foundEmployee = employeeService.getEmployeeById(1L);
        assertNotNull(foundEmployee);
        assertEquals("John", foundEmployee.getFirstName());
    }

    @Test
    void testUpdateEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        employee.setLastName("Smith");
        Employee updatedEmployee = employeeService.updateEmployee(1L, employee);
        assertNotNull(updatedEmployee);
        assertEquals("Smith", updatedEmployee.getLastName());
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteEmployee(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}