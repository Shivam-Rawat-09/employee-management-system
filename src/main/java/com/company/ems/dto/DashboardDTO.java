package com.company.ems.dto;

import java.time.LocalDate;
import java.util.List;

public class DashboardDTO {
    private int totalEmployees;
    private int totalDepartments;
    private int totalLeaveRequests;
    private List<LeaveSummary> leaveSummary;
    private List<AttendanceSummary> attendanceSummary;

    // Getters and Setters

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(int totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public int getTotalLeaveRequests() {
        return totalLeaveRequests;
    }

    public void setTotalLeaveRequests(int totalLeaveRequests) {
        this.totalLeaveRequests = totalLeaveRequests;
    }

    public List<LeaveSummary> getLeaveSummary() {
        return leaveSummary;
    }

    public void setLeaveSummary(List<LeaveSummary> leaveSummary) {
        this.leaveSummary = leaveSummary;
    }

    public List<AttendanceSummary> getAttendanceSummary() {
        return attendanceSummary;
    }

    public void setAttendanceSummary(List<AttendanceSummary> attendanceSummary) {
        this.attendanceSummary = attendanceSummary;
    }

    // Inner classes for summaries
    public static class LeaveSummary {
        private String leaveType;
        private int totalDays;

        // Getters and Setters
        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public int getTotalDays() {
            return totalDays;
        }

        public void setTotalDays(int totalDays) {
            this.totalDays = totalDays;
        }
    }

    public static class AttendanceSummary {
        private LocalDate date;
        private int presentCount;
        private int absentCount;

        // Getters and Setters
        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public int getPresentCount() {
            return presentCount;
        }

        public void setPresentCount(int presentCount) {
            this.presentCount = presentCount;
        }

        public int getAbsentCount() {
            return absentCount;
        }

        public void setAbsentCount(int absentCount) {
            this.absentCount = absentCount;
        }
    }
}