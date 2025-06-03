package com.company.ems.service;

import com.company.ems.model.LeaveRequest;
import com.company.ems.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequest> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequestDetails) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequest.setStartDate(leaveRequestDetails.getStartDate());
        leaveRequest.setEndDate(leaveRequestDetails.getEndDate());
        leaveRequest.setReason(leaveRequestDetails.getReason());
        leaveRequest.setStatus(leaveRequestDetails.getStatus());
        leaveRequest.setApprovedBy(leaveRequestDetails.getApprovedBy());
        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}