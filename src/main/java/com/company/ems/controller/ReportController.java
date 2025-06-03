package com.company.ems.controller;

import com.company.ems.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/attendance")
    public List<?> getAttendanceReport(@RequestParam String startDate, @RequestParam String endDate) {
        return reportService.generateAttendanceReport(startDate, endDate);
    }

    @GetMapping("/reports/leave")
    public List<?> getLeaveReport(@RequestParam String year) {
        return reportService.generateLeaveReport(year);
    }

    @GetMapping("/reports/employee")
    public List<?> getEmployeeReport() {
        return reportService.generateEmployeeReport();
    }
}