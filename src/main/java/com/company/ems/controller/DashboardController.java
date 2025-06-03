package com.company.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        // Add attributes to the model for the dashboard view
        model.addAttribute("title", "Dashboard");
        // Add more attributes as needed for the dashboard data
        return "dashboard/index"; // Return the view name for the dashboard
    }
}