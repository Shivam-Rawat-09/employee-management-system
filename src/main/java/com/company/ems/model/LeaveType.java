package com.company.ems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_types")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    @Column(name = "days_allowed_per_year", nullable = false)
    private Integer daysAllowedPerYear;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    // Constructors
    public LeaveType() {
    }

    public LeaveType(String typeName, Integer daysAllowedPerYear) {
        this.typeName = typeName;
        this.daysAllowedPerYear = daysAllowedPerYear;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDaysAllowedPerYear() {
        return daysAllowedPerYear;
    }

    public void setDaysAllowedPerYear(Integer daysAllowedPerYear) {
        this.daysAllowedPerYear = daysAllowedPerYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}