package com.company.ems.service;

import com.company.ems.model.Attendance;
import com.company.ems.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance clockIn(Long employeeId, LocalDate date) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setDate(date);
        attendance.setClockInTime(LocalDate.now()); // Set current time for clock-in
        attendance.setStatus("PRESENT");
        return attendanceRepository.save(attendance);
    }

    public Attendance clockOut(Long employeeId, LocalDate date) {
        Attendance attendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, date);
        if (attendance != null) {
            attendance.setClockOutTime(LocalDate.now()); // Set current time for clock-out
            attendance.setTotalHours(calculateTotalHours(attendance));
            return attendanceRepository.save(attendance);
        }
        return null; // Handle case where attendance record does not exist
    }

    public List<Attendance> getAttendanceByEmployeeId(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    private double calculateTotalHours(Attendance attendance) {
        // Logic to calculate total hours based on clock-in and clock-out times
        return 0; // Placeholder for actual calculation
    }
}