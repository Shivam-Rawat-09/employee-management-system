package com.company.ems.controller;

import com.company.ems.model.LeaveRequest;
import com.company.ems.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveService.getAllLeaveRequests();
        return ResponseEntity.ok(leaveRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable Long id) {
        LeaveRequest leaveRequest = leaveService.getLeaveRequestById(id);
        return ResponseEntity.ok(leaveRequest);
    }

    @PostMapping
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        LeaveRequest createdLeaveRequest = leaveService.createLeaveRequest(leaveRequest);
        return ResponseEntity.status(201).body(createdLeaveRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequest leaveRequest) {
        LeaveRequest updatedLeaveRequest = leaveService.updateLeaveRequest(id, leaveRequest);
        return ResponseEntity.ok(updatedLeaveRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id) {
        leaveService.deleteLeaveRequest(id);
        return ResponseEntity.noContent().build();
    }
}