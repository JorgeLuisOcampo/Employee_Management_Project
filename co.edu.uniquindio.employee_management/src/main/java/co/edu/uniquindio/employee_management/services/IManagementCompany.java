package co.edu.uniquindio.employee_management.services;

import co.edu.uniquindio.employee_management.model.Department;
import co.edu.uniquindio.employee_management.model.Employee;
import co.edu.uniquindio.employee_management.model.Project;

public interface IManagementCompany {
    public void createDepartment(Department department);

    public void updateDepartment(int code, Department newDepartment);

    public void deleteDepartment(int code);

    public void addEmployee(Employee employee);

    public void deleteEmployee(String id);

    public void updateEmployee(String id, Employee newEmployee);

    public void createProject(Project project);

    public void updateProject(int code, Project project);

    public void deleteProject(int code);

    public void associateProjectDepartment(Project project, Department department);

    public void disassociateProjectDepartment(Project project, int code);

    public void completeProject(Project project);

    public void associateProjectTechnician(int code, String id);

    public void disassociateProjectTechnician(int code, String id);

    public String departmentMostTechnicians();

    public String currentProjectMostEmployees();
}