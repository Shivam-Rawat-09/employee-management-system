import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setEmployeeId("E123");
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setDateOfBirth("1990-01-01");
        employee.setGender("Male");
        employee.setAddress("123 Main St, Anytown, USA");
        employee.setHireDate("2023-01-01");
        employee.setDepartmentId(1L);
        employee.setPosition("Software Engineer");
        employee.setSalary(60000.00);
        employee.setStatus("ACTIVE");
        employee.setEmergencyContactName("Jane Doe");
        employee.setEmergencyContactPhone("0987654321");
        employeeRepository.save(employee);
    }

    @Test
    public void testFindById() {
        Optional<Employee> foundEmployee = employeeRepository.findById(employee.getId());
        assertThat(foundEmployee).isPresent();
        assertThat(foundEmployee.get().getFirstName()).isEqualTo("John");
    }

    @Test
    public void testDeleteById() {
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> deletedEmployee = employeeRepository.findById(employee.getId());
        assertThat(deletedEmployee).isNotPresent();
    }

    @Test
    public void testFindByEmail() {
        Optional<Employee> foundEmployee = employeeRepository.findByEmail(employee.getEmail());
        assertThat(foundEmployee).isPresent();
        assertThat(foundEmployee.get().getLastName()).isEqualTo("Doe");
    }
}