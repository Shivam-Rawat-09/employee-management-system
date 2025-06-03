package com.company.ems.service;

import com.company.ems.model.Employee;
import com.company.ems.model.Department;
import com.company.ems.model.LeaveRequest;
import com.company.ems.model.Attendance;
import com.company.ems.repository.EmployeeRepository;
import com.company.ems.repository.DepartmentRepository;
import com.company.ems.repository.LeaveRequestRepository;
import com.company.ems.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<LeaveRequest> getLeaveRequestsByEmployeeId(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    public List<Attendance> getAttendanceRecordsByEmployeeId(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    // Additional report generation methods can be added here
}