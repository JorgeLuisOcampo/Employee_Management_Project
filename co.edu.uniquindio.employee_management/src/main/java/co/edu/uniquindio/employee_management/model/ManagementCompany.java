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
     * @return Management company's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to modify the management company's name
     * @param name New name of the management company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to obtain the list of departments in the management company
     * @return List of departments in the management company
     */
    public LinkedList<Department> getDepartmentsList() {
        return departmentsList;
    }

    /**
     * Method to modify the list of departments in the management company
     * @param departmentsList New list of departments
     */
    public void setDepartmentsList(LinkedList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public LinkedList<Technician> getTechniciansList() {
        return techniciansList;
    }

    public void setTechniciansList(LinkedList<Technician> techniciansList) {
        this.techniciansList = techniciansList;
    }

    public LinkedList<Manager> getManagerList() {
        return managerList;
    }

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
            if (department.getCode() == code){
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
            if (department.getCode() == code){
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

    public void addEmployee(Employee employee) {
        if (verifyEmployee(employee.getId())){
            return;
        }
        if (employee instanceof Manager manager) {
            addManager(manager);
        }
        else if (employee instanceof Technician technician) {
            addTechnician(technician);
        }
    }

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

    public void addManager(Manager manager) {
        Department department = manager.getassociatedDepartment();
        if (department != null && department.getManagerAssociated() == null) {
            managerList.add(manager);
            manager.getassociatedDepartment().setManagerAssociated(manager);
        }
    }

    public void addTechnician(Technician technician) {
        if (technician.getassociatedDepartment() != null){
            techniciansList.add(technician);
        }
    }

    public void deleteManager(String id) {
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

    public void createProject(Project project) {
        if (!verifyProjects(project.getCode())){
            projectsList.add(project);
            return;
        }
    }

    public boolean verifyProjects(int code) {
        for (Project project : projectsList) {
            if (project.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public void updateProject(Project project) {
        for (Project projectCheck : projectsList){
            if (projectCheck.getCode() == project.getCode() ||
                    !verifyProjects(project.getCode())){
                projectCheck.setCode(project.getCode());
                projectCheck.setName(project.getName());
            }
        }
    }

    public void deleteProject(int code) {
        for (Project project : projectsList) {
            if (project.getCode() == code && !project.isCompleted()) {
                dissacociateDepartmentsProject(project.getDepartmentsList());
                dissacociateEmployeesProject(project.getAssignedEmployeesList());
                return;
            }
        }
    }

    public void dissacociateDepartmentsProject(LinkedList<Department> departmentsList) {
        for (Department department : departmentsList) {
            department.setAssociatedProject(null);
        }
    }

    public void dissacociateEmployeesProject(LinkedList<Employee> employeesList) {
        for (Employee employee : employeesList) {
            employee.setAssociatedProject(null);
        }
    }

    public void associateProjectDepartment(Project project, Department department) {
        if (department.getAssociatedProject() == null) {
            department.setAssociatedProject(project);
            department.getManagerAssociated().setAssociatedProject(project);
        }
    }

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

    public void completeProject(Project project) {
        if (!project.isCompleted()) {
            project.setCompleted(true);
            completeManagersProject(project.getDepartmentsList());
            dissacociateDepartmentsProject(project.getDepartmentsList());
            dissacociateEmployeesProject(project.getAssignedEmployeesList());
        }
    }

    private void completeManagersProject(LinkedList<Department> departmentsList) {
        for (Department department : departmentsList) {
            department.getManagerAssociated().changeNumberCompletedProjects(1);
        }
    }

    @Override
    public void associateProjectTechnician(int code, String id) {
        Technician technician = findTechnician(id);
        if (technician != null && technician.getAssociatedProject() == null) {
            technician.getassociatedDepartment().getManagerAssociated().associateProjectTechnician(code, id);
        }
    }

    @Override
    public void disassociateProjectTechnician(int code, String id) {
        Technician technician = findTechnician(id);
        if (technician != null && technician.getAssociatedProject() != null) {
            technician.getassociatedDepartment().getManagerAssociated().disassociateProjectTechnician(code, id);
        }
    }

    public Technician findTechnician(String id) {
        for (Technician technician : techniciansList) {
            if (technician.getId().equals(id)) {
                return technician;
            }
        }
        return null;
    }
}