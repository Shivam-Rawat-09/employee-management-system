package com.company.ems.controller;

import com.company.ems.model.Attendance;
import com.company.ems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/clock-in")
    public Attendance clockIn(@RequestBody Attendance attendance) {
        return attendanceService.clockIn(attendance);
    }

    @PostMapping("/clock-out")
    public Attendance clockOut(@RequestBody Attendance attendance) {
        return attendanceService.clockOut(attendance);
    }

    @GetMapping("/{employeeId}")
    public List<Attendance> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        return attendanceService.getAttendanceByEmployeeId(employeeId);
    }

    @GetMapping("/report/{employeeId}")
    public List<Attendance> getAttendanceReport(@PathVariable Long employeeId) {
        return attendanceService.getAttendanceReport(employeeId);
    }
}