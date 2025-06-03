package com.company.ems.service;

import com.company.ems.model.LeaveRequest;
import com.company.ems.repository.LeaveRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LeaveServiceTest {

    @InjectMocks
    private LeaveService leaveService;

    @Mock
    private LeaveRequestRepository leaveRequestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setId(1L);
        leaveRequest.setEmployeeId(1L);
        leaveRequest.setLeaveTypeId(1L);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setEndDate(LocalDate.now().plusDays(5));
        leaveRequest.setReason("Vacation");
        leaveRequest.setStatus("PENDING");

        when(leaveRequestRepository.save(any(LeaveRequest.class))).thenReturn(leaveRequest);

        LeaveRequest createdRequest = leaveService.createLeaveRequest(leaveRequest);

        assertNotNull(createdRequest);
        assertEquals("Vacation", createdRequest.getReason());
        verify(leaveRequestRepository, times(1)).save(leaveRequest);
    }

    @Test
    void testGetLeaveRequestById() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setId(1L);
        leaveRequest.setEmployeeId(1L);
        
        when(leaveRequestRepository.findById(1L)).thenReturn(Optional.of(leaveRequest));

        LeaveRequest foundRequest = leaveService.getLeaveRequestById(1L);

        assertNotNull(foundRequest);
        assertEquals(1L, foundRequest.getId());
        verify(leaveRequestRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setId(1L);
        leaveRequest.setStatus("APPROVED");

        when(leaveRequestRepository.findById(1L)).thenReturn(Optional.of(leaveRequest));
        when(leaveRequestRepository.save(any(LeaveRequest.class))).thenReturn(leaveRequest);

        LeaveRequest updatedRequest = leaveService.updateLeaveRequest(1L, leaveRequest);

        assertNotNull(updatedRequest);
        assertEquals("APPROVED", updatedRequest.getStatus());
        verify(leaveRequestRepository, times(1)).save(leaveRequest);
    }

    @Test
    void testDeleteLeaveRequest() {
        doNothing().when(leaveRequestRepository).deleteById(1L);

        leaveService.deleteLeaveRequest(1L);

        verify(leaveRequestRepository, times(1)).deleteById(1L);
    }
}