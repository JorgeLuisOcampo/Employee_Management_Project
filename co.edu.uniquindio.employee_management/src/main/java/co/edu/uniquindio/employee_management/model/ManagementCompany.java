package co.edu.uniquindio.employee_management.model;

import co.edu.uniquindio.employee_management.services.IManageTechnician;

import java.util.LinkedList;

public class ManagementCompany implements IManageTechnician {
    private String name;
    private LinkedList<Department> departmentsList;
    private LinkedList<Technician> techniciansList;
    private LinkedList<Manager> managerList;
    private LinkedList<Project> projectsList;

    /**
     * Method constructor for the class ManagementCompany
     *
     * @param name Name of the management company to create
     */
    public ManagementCompany(String name) {
        this.name = name;
        this.departmentsList = new LinkedList<>();
        this.techniciansList = new LinkedList<>();
        this.managerList = new LinkedList<>();
        this.projectsList = new LinkedList<>();
    }

    /**
     * Method to obtain the management company's name
     *
     * @return Management company's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to modify the management company's name
     *
     * @param name New name of the management company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to obtain the list of departments in the management company
     *
     * @return List of departments in the management company
     */
    public LinkedList<Department> getDepartmentsList() {
        return departmentsList;
    }

    /**
     * Method to modify the list of departments in the management company
     *
     * @param departmentsList New list of departments
     */
    public void setDepartmentsList(LinkedList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    /**
     * Method to obtain the technicians list
     * @return Technicians list
     */
    public LinkedList<Technician> getTechniciansList() {
        return techniciansList;
    }

    /**
     * Method to modify the technicians list
     * @param techniciansList New technicians list
     */
    public void setTechniciansList(LinkedList<Technician> techniciansList) {
        this.techniciansList = techniciansList;
    }

    /**
     * Method to obtain the managers list
     * @return Managers list
     */
    public LinkedList<Manager> getManagerList() {
        return managerList;
    }

    /**
     * Method to modify the managers list
     * @param managerList New managers list
     */
    public void setManagerList(LinkedList<Manager> managerList) {
        this.managerList = managerList;
    }

    /**
     * Method to obtain the list of projects in the management company
     * @return List of projects in the management company
     */
    public LinkedList<Project> getProjectsList() {
        return projectsList;
    }

    /**
     * Method to modify the list of projects in the management company
     * @param projectsList New list of projects
     */
    public void setProjectsList(LinkedList<Project> projectsList) {
        this.projectsList = projectsList;
    }

    /**
     * Method to assign a department to the departmentsList
     * @param department Department to create
     */
    public void createDepartment(Department department) {
        if (!verifyDepartment(department.getCode())) {
            departmentsList.add(department);
        }
    }

    /**
     * Method to verify if exist a department with the same code as one given
     * @param code Code to verify
     * @return Boolean if the department was found or not
     */
    public boolean verifyDepartment(int code) {
        boolean found = false;
        for (Department department : departmentsList) {
            if (department.getCode() == code) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Method to update a department's information
     * @param code Code of the department to update
     * @param newDepartment Department with the new information
     */
    public void updateDepartment(int code, Department newDepartment) {
        for (Department department : departmentsList) {
            if (department.getCode() == code) {
                if (!verifyDepartment(department.getCode()) || newDepartment.getCode() == department.getCode()) {
                    department.setName(department.getName());
                    department.setCode(newDepartment.getCode());
                    break;
                }
            }
        }
    }

    /**
     * Method to delete a department from the departmentsList
     * @param code Code of the department to delete
     */
    public void deleteDepartment(int code) {
        for (Department department : departmentsList) {
            if (department.getCode() == code && department.getTechniciansList().isEmpty()
                    && department.getManagerAssociated() == null) {
                departmentsList.remove(department);
                break;
            }
        }
    }

    /**
     * Method to add an employee to the technicians list or managers list
     * @param employee Employee to add
     */
    public void addEmployee(Employee employee) {
        if (verifyEmployee(employee.getId())){
            return;
        }
        if (!verifyDepartment(employee.getassociatedDepartment().getCode())) {
            return;
        }
        if (employee instanceof Manager manager) {
            addManager(manager);
        }
        else if (employee instanceof Technician technician) {
            addTechnician(technician);
        }
    }

    /**
     * Method to verify if exists one employee in the management company with the same ID as one given
     * @param id ID given to find
     * @return Boolean about if the employee was found or not
     */
    public boolean verifyEmployee(String id) {
        for (Technician technician : techniciansList) {
            if (technician.getId().equals(id)) {
                return true;
            }
        }
        for (Manager manager : managerList) {
            if (manager.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to add a manager to the managersList and assign it to its department
     * @param manager Manager to add
     */
    public void addManager(Manager manager) {
        if (manager.getassociatedDepartment().getManagerAssociated() == null) {
            managerList.add(manager);
            manager.getassociatedDepartment().setManagerAssociated(manager);
        }
    }

    /**
     * Method to add a technician to the techniciansList and assign it to its department
     * @param technician Technician to add
     */
    public void addTechnician(Technician technician) {
        if (technician.getassociatedDepartment() != null){
            techniciansList.add(technician);
            technician.getassociatedDepartment().getTechniciansList().add(technician);
        }
    }

    /**
     * Method to delete an employee from the managers list or technicians list
     * @param id ID of the employee to delete
     */
    public void deleteEmployee(String id) {
        for (Manager manager : managerList) {
            if (manager.getId().equals(id)) {
                managerList.remove(manager);
                manager.getassociatedDepartment().setManagerAssociated(null);
                break;
            }
        }
        for (Technician technician : techniciansList) {
            if (technician.getId().equals(id)) {
                techniciansList.remove(technician);
                technician.getassociatedDepartment().getTechniciansList().remove(technician);
                break;
            }
        }
    }

    /**
     * Method to update an employee's information
     * @param id ID of the employee to update information
     * @param newEmployee Employee with the new information
     */
    public void updateEmployee(String id, Employee newEmployee) {
        if (verifyEmployee(id) || !newEmployee.getId().equals(id)) {
            return;
        }
        for (Manager manager : managerList) {
            if (manager.getId().equals(id)) {
                manager.setName(newEmployee.getName());
                manager.setId(newEmployee.getId());
                return;
            }
        }
        for (Technician technician : techniciansList) {
            if (technician.getId().equals(id)) {
                technician.setName(newEmployee.getName());
                technician.setId(newEmployee.getId());
                return;
            }
        }
    }

    /**
     * Method to add a project to the projects list
     * @param project Project to add
     */
    public void createProject(Project project) {
        if (!verifyProjects(project.getCode())){
            projectsList.add(project);
            return;
        }
    }

    /**
     * Method to verify if exists a project with the same code as one given
     * @param code Code given to verify
     * @return Boolean if the project was found or not
     */
    public boolean verifyProjects(int code) {
        for (Project project : projectsList) {
            if (project.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to update a project's information
     * @param code Code of the project to update information
     * @param newProject Project with the new information
     */
    public void updateProject(int code, Project newProject) {
        if (verifyProjects(code) || !(newProject.getCode() == code)) {
            return;
        }
        for (Project project : projectsList){
            if (project.getCode() == code){
                project.setCode(newProject.getCode());
                project.setName(newProject.getName());
            }
        }
    }

    /**
     * Method to delete a project from the projects list and disassociate everything from it
     * @param code Code of the project to delete
     */
    public void deleteProject(int code) {
        for (Project project : projectsList) {
            if (project.getCode() == code && !project.isCompleted()) {
                disassociateDepartmentsProject(project.getDepartmentsList());
                disassociateEmployeesProject(project.getAssignedEmployeesList());
                return;
            }
        }
    }

    /**
     * Method to disassociate all the departments from a departments list
     * @param departmentsList Departments list to disassociate
     */
    public void disassociateDepartmentsProject(LinkedList<Department> departmentsList) {
        for (Department department : departmentsList) {
            department.setAssociatedProject(null);
        }
    }

    /**
     * Method to disassociate all the employees from a departments list
     * @param employeesList Employees list to disassociate
     */
    public void disassociateEmployeesProject(LinkedList<Employee> employeesList) {
        for (Employee employee : employeesList) {
            employee.setAssociatedProject(null);
        }
    }

    /**
     * Method to assign a project to a department
     * @param project Project to assign
     * @param department Department to get assigned with
     */
    public void associateProjectDepartment(Project project, Department department) {
        if (!verifyProjects(project.getCode())) {
            return;
        }
        if (department.getAssociatedProject() == null && department.getManagerAssociated() != null) {
            department.setAssociatedProject(project);
            department.getManagerAssociated().setAssociatedProject(project);
            project.getDepartmentsList().add(department);
            project.getAssignedEmployeesList().add(department.getManagerAssociated());
        }
    }

    /**
     * Method to disassociate a project from a department
     * @param project Project to disassociate
     * @param code Department to get disassociated with
     */
    public void disassociateProjectDepartment(Project project, int code) {
        if (project.isCompleted()) {
            return;
        }
        for (Department departmentCheck : project.getDepartmentsList()) {
            if (departmentCheck.getCode() == code) {
                departmentCheck.setAssociatedProject(null);
                departmentCheck.getManagerAssociated().setAssociatedProject(null);
            }
        }
    }

    /**
     * Method to complete a project
     * @param project Project to complete
     */
    public void completeProject(Project project) {
        if (!project.isCompleted() && verifyProjects(project.getCode())) {
            project.setCompleted(true);
            completeManagersProject(project.getDepartmentsList());
            disassociateDepartmentsProject(project.getDepartmentsList());
            disassociateEmployeesProject(project.getAssignedEmployeesList());
        }
    }

    /**
     * Method to add one more project completed to the managers of the departments assigned
     * @param departmentsList Departments list of the project
     */
    private void completeManagersProject(LinkedList<Department> departmentsList) {
        for (Department department : departmentsList) {
            department.getManagerAssociated().changeNumberCompletedProjects(1);
        }
    }

    /**
     * Method to associate a technician to a project
     * @param code Code of the project
     * @param id ID of the technician
     */
    @Override
    public void associateProjectTechnician(int code, String id) {
        Technician technician = findTechnician(id);
        if (technician != null && technician.getAssociatedProject() == null) {
            technician.getassociatedDepartment().getManagerAssociated().associateProjectTechnician(code, id);
        }
    }

    /**
     * Method to disassociate a technician from a project
     * @param code Code of the project
     * @param id ID of the technician to disassociate
     */
    @Override
    public void disassociateProjectTechnician(int code, String id) {
        Technician technician = findTechnician(id);
        if (technician != null && technician.getAssociatedProject() != null) {
            technician.getassociatedDepartment().getManagerAssociated().disassociateProjectTechnician(code, id);
        }
    }

    /**
     * Method to find a technician by an ID given
     * @param id ID of technician to find
     * @return If the technician wasn't found returns null otherwise returns the technician
     */
    public Technician findTechnician(String id) {
        for (Technician technician : techniciansList) {
            if (technician.getId().equals(id)) {
                return technician;
            }
        }
        return null;
    }

    /**
     * Method to get the name of the department with most technicians
     * @return The name of the department with most technicians
     */
    public String departmentMostTechnicians(){
        int max = 0;
        String departmentName = "";
        for (Department department : departmentsList) {
           if (department.getTechniciansList().size() > max){
               max = department.getTechniciansList().size();
               departmentName = department.getName();
           }
        }
        return departmentName;
    }

    /**
     * Method to get the name of the current project with most employees
     * @return The name of the project with most employees
     */
    public String currentProjectMostEmployees(){
        int max = 0;
        String projectName = "";
        for (Project project : projectsList) {
            if (project.getAssignedEmployeesList().size() > max && !project.isCompleted()) {
                max = project.getAssignedEmployeesList().size();
                projectName = project.getName();
            }
        }
        return projectName;
    }
}