package co.edu.uniquindio.employee_management.factory;

import co.edu.uniquindio.employee_management.model.*;

import java.util.LinkedList;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private static ManagementCompany managementCompany;

    /**
     * Method constructor of the class ModelFactory
     */
    private ModelFactory() {
        initializeData();
    }

    /**
     * Method to get the only model factory instance
     * @return The only model factory instance
     */
    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    /**
     * Method to get the only management company instance
     * @return The only management company instance
     */
    public ManagementCompany getManagementCompany() {
        return managementCompany;
    }

    /**
     * Method to initialize data in the management company
     */
    public static void initializeData() {
        managementCompany = new ManagementCompany("UQ Software");
        Department department1 = new Department("Bloque 1", 1);
        Department department2 = new Department("Bloque 2", 2);
        Technician technician1 = new Technician("Alejo", "20", department1);
        Technician technician2 = new Technician("Sofi", "21", department2);
        Manager manager1 = new Manager("Vale", "22", department1);
        Manager manager2 = new Manager("Carol", "23", department2);
        Project project1 = new Project("Primero", 1);
        Project project2 = new Project("Segundo", 2);
        managementCompany.createDepartment(department1);
        managementCompany.createDepartment(department2);
        managementCompany.addEmployee(technician1);
        managementCompany.addEmployee(technician2);
        managementCompany.addEmployee(manager1);
        managementCompany.addEmployee(manager2);
        managementCompany.createProject(project1);
        managementCompany.createProject(project2);
        managementCompany.associateProjectDepartment(project1, department1);
        managementCompany.associateProjectDepartment(project2, department2);
        managementCompany.associateProjectTechnician(2, "20");
        //managementCompany.completeProject(project1);
    }

    public void createDepartment(Department department){
        managementCompany.createDepartment(department);
    }

    public void updateDepartment(int code, Department newDepartment){
        managementCompany.updateDepartment(code, newDepartment);
    }

    public void deleteDepartment(int code){
        managementCompany.deleteDepartment(code);
    }

    public void addEmployee(Employee employee){
        managementCompany.addEmployee(employee);
    }

    public void deleteEmployee(String id){
        managementCompany.deleteEmployee(id);
    }

    public void updateEmployee(String id, Employee newEmployee){
        managementCompany.updateEmployee(id, newEmployee);
    }

    public void createProject(Project project){
        managementCompany.createProject(project);
    }

    public void updateProject(int code, Project project){
        managementCompany.updateProject(code, project);
    }

    public void deleteProject(int code){
        managementCompany.deleteProject(code);
    }

    public void associateProjectDepartment(Project project, Department department){
        managementCompany.associateProjectDepartment(project, department);
    }

    public void disassociateProjectDepartment(Project project, int code){
        managementCompany.disassociateProjectDepartment(project, code);
    }

    public void completeProject(Project project){
        managementCompany.completeProject(project);
    }

    public void associateProjectTechnician(int code, String id){
        managementCompany.associateProjectTechnician(code, id);
    }

    public void disassociateProjectTechnician(int code, String id){
        managementCompany.disassociateProjectTechnician(code, id);
    }

    public String departmentMostTechnicians(){
        return managementCompany.departmentMostTechnicians();
    }

    public String currentProjectMostEmployees(){
        return managementCompany.currentProjectMostEmployees();
    }
}