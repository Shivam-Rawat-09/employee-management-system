# Employee Management System

## Project Overview

A comprehensive web-based Employee Management System built with Java Spring Boot, designed to streamline HR operations and employee data management. This system provides a modern, intuitive interface for managing employee information, attendance, leave requests, and organizational structure.

## 🎯 Key Features for HR Demonstration

### Employee Management
- **Employee Registration & Profiles**: Complete employee onboarding with personal details, contact information, emergency contacts
- **Employee Directory**: Searchable and filterable employee listing with photos and key information
- **Organization Chart**: Visual department hierarchy and reporting structure
- **Employee Status Management**: Active, inactive, terminated employee status tracking

### Leave Management
- **Leave Request System**: Employees can submit leave requests with approval workflow
- **Leave Balance Tracking**: Automatic calculation of available leave days (vacation, sick, personal)
- **Manager Approval**: Department managers can approve/reject leave requests
- **Leave Calendar**: Visual calendar showing team leave schedules

### Attendance Management
- **Time Tracking**: Simple clock-in/clock-out system
- **Attendance Reports**: Daily, weekly, monthly attendance summaries
- **Overtime Tracking**: Automatic overtime calculation based on working hours
- **Attendance Analytics**: Late arrivals, early departures, and attendance patterns

### Reporting & Analytics
- **HR Dashboard**: Executive summary with key metrics and charts
- **Employee Reports**: Detailed reports on attendance, leave usage, and performance metrics
- **Department Analytics**: Team-wise statistics and comparisons
- **Export Functionality**: PDF and Excel export for all reports

### User Management & Security
- **Role-Based Access Control**: HR Admin, Manager, and Employee roles with appropriate permissions
- **Secure Authentication**: Login system with password encryption
- **Profile Management**: Users can update their own profiles and passwords

## 🛠 Technical Specifications

### Technology Stack
- **Backend**: Java 17, Spring Boot 3.x
- **Build Tool**: Maven
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript, Bootstrap 5
- **Database**: MySQL 8.0
- **Security**: Spring Security
- **Template Engine**: Thymeleaf
- **Development**: Spring Boot DevTools for hot reload

### Architecture
- **MVC Pattern**: Clean separation of concerns
- **RESTful APIs**: For future mobile app integration
- **Responsive Design**: Mobile-friendly interface
- **Data Validation**: Server-side and client-side validation
- **Exception Handling**: Comprehensive error handling and user-friendly messages

## 📋 Detailed Requirements

### Database Schema

#### Employee Table
- id (Primary Key)
- employee_id (Unique identifier)
- first_name, last_name
- email (unique), phone
- date_of_birth, gender
- address (street, city, state, zip)
- hire_date, termination_date
- department_id (Foreign Key)
- position, salary
- manager_id (Self-referencing Foreign Key)
- status (ACTIVE, INACTIVE, TERMINATED)
- emergency_contact_name, emergency_contact_phone
- profile_picture_url
- created_at, updated_at

#### Department Table
- id (Primary Key)
- department_name
- department_code
- manager_id (Foreign Key to Employee)
- budget, description
- created_at, updated_at

#### Leave Management Tables
- Leave_Type: id, type_name, days_allowed_per_year
- Leave_Request: id, employee_id, leave_type_id, start_date, end_date, reason, status, approved_by, request_date, approval_date
- Leave_Balance: id, employee_id, leave_type_id, allocated_days, used_days, remaining_days, year

#### Attendance Table
- id (Primary Key)
- employee_id (Foreign Key)
- date, clock_in_time, clock_out_time
- total_hours, overtime_hours
- status (PRESENT, ABSENT, LATE, HALF_DAY)
- notes

#### User Authentication
- User: id, username, password_hash, employee_id, role, last_login, account_status, created_at
- Role: id, role_name, permissions

### Key Functionalities to Implement

#### 1. Employee Management Module
- Employee CRUD operations with form validation
- Employee search and filtering (by department, status, hire date)
- Employee profile pages with complete information
- Bulk employee import from CSV/Excel
- Employee photo upload and management

#### 2. Dashboard & Analytics
- HR Executive Dashboard with KPIs:
  - Total employees, new hires this month, turnover rate
  - Attendance statistics, leave requests pending
  - Department-wise employee distribution charts
  - Recent activities feed

#### 3. Leave Management System
- Leave request form with date picker and validation
- Manager approval workflow with email notifications
- Leave calendar integration
- Automatic leave balance calculation
- Leave policy configuration

#### 4. Attendance System
- Simple clock-in/out interface
- Attendance marking for managers (for employees without computer access)
- Monthly attendance reports
- Late arrival and early departure tracking
- Overtime calculation based on company policies

#### 5. Reporting Module
- Employee reports (personal details, attendance, leave history)
- Department reports (team statistics, attendance summaries)
- Payroll reports (hours worked, overtime, leave deductions)
- Custom date range filtering for all reports
- PDF generation using iText or similar library

### Security Requirements
- **Authentication**: Spring Security with form-based login
- **Authorization**: Role-based access control (RBAC)
- **Password Policy**: Strong password requirements
- **Session Management**: Secure session handling
- **Data Validation**: Input sanitization and validation
- **SQL Injection Prevention**: Using JPA/Hibernate prepared statements

### UI/UX Requirements
- **Responsive Design**: Bootstrap-based responsive layout
- **Modern Interface**: Clean, professional design suitable for corporate environment
- **Navigation**: Intuitive sidebar navigation with role-based menu items
- **Forms**: User-friendly forms with proper validation messages
- **Tables**: Sortable, searchable data tables for employee listings
- **Charts**: Interactive charts for analytics (Chart.js integration)

## 🚀 Development Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0
- IDE (IntelliJ IDEA or Eclipse recommended)

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/company/ems/
│   │       ├── EmsApplication.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── dto/
│   └── resources/
│       ├── application.properties
│       ├── static/ (CSS, JS, images)
│       └── templates/ (Thymeleaf templates)
└── test/
```

### Key Dependencies (pom.xml)
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-thymeleaf
- spring-boot-starter-validation
- mysql-connector-java
- spring-boot-devtools
- spring-boot-starter-test

### Database Configuration
```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 📊 Demo Data for HR Presentation

### Sample Departments
- Human Resources, Engineering, Sales, Marketing, Finance, Operations

### Sample Employee Roles
- HR Manager, Software Engineer, Sales Representative, Marketing Specialist, Accountant, Operations Manager

### Sample Leave Types
- Annual Leave (21 days), Sick Leave (10 days), Personal Leave (5 days), Maternity/Paternity Leave

## 🎨 UI Pages to Implement

### Main Pages
1. **Login Page**: Professional login form
2. **Dashboard**: Role-specific dashboard with widgets and charts
3. **Employee Directory**: Grid/list view with search and filters
4. **Employee Profile**: Detailed employee information page
5. **Add/Edit Employee**: Comprehensive employee form
6. **Leave Management**: Leave request form and approval interface
7. **Attendance**: Clock-in/out interface and attendance reports
8. **Reports**: Various report generation pages
9. **Settings**: User profile and system settings

### HR-Specific Features
- **Onboarding Checklist**: New employee onboarding workflow
- **Performance Tracking**: Basic performance review module
- **Document Management**: Employee document storage
- **Compliance Reports**: Reports for HR compliance requirements

## 📈 Success Metrics for HR Demo
- **User Experience**: Intuitive navigation, minimal clicks to complete tasks
- **Data Accuracy**: Reliable attendance and leave calculations
- **Reporting**: Comprehensive reports for HR decision-making
- **Security**: Proper access control and data protection
- **Performance**: Fast loading times, responsive interface

## 🔧 Development Best Practices
- Follow Spring Boot conventions and project structure
- Implement comprehensive error handling and logging
- Use DTOs for data transfer between layers
- Write unit tests for service layer methods
- Implement proper validation for all user inputs
- Use transactions for data consistency
- Implement soft delete for employee records
- Add audit trails for sensitive operations

## 📝 Future Enhancement Ideas
- Mobile application for employee self-service
- Integration with payroll systems
- Advanced analytics and reporting
- Document management system
- Performance review module
- Training and certification tracking
- Employee self-service portal

---

This README provides a complete blueprint for building a professional Employee Management System that will showcase modern HR management capabilities while demonstrating technical expertise in Java Spring Boot development.