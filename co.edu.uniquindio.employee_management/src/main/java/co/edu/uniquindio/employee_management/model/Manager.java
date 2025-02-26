package co.edu.uniquindio.employee_management.model;

import co.edu.uniquindio.employee_management.services.IContributor;
import co.edu.uniquindio.employee_management.services.IManageTechnician;

public class Manager extends Employee implements IManageTechnician{
    private int numberCurrentProjects;
    private int numberCompletedProjects;

    /**
     * Method constructor for the class Manager
     * @param name Name of the manager to create
     * @param id ID of the manager to create
     * @param department Department of the manager to create
     */
    public Manager(String name, String id, Department department) {
        super(name, id, department);
        numberCurrentProjects = 0;
        numberCompletedProjects = 0;
    }

    /**
     * Method to obtain the number of current projects managed by the manager
     * @return Number of current projects
     */
    public int getNumberCurrentProjects() {
        return numberCurrentProjects;
    }

    /**
     * Method to modify the number of current projects managed by the manager
     * @param numberCurrentProjects New number of current projects
     */
    public void setNumberCurrentProjects(int numberCurrentProjects) {
        this.numberCurrentProjects = numberCurrentProjects;
    }

    /**
     * Method to obtain the number of completed projects managed by the manager
     * @return Number of completed projects
     */
    public int getNumberCompletedProjects() {
        return numberCompletedProjects;
    }

    /**
     * Method to modify the number of completed projects managed by the manager
     * @param numberCompletedProjects New number of completed projects
     */
    public void setNumberCompletedProjects(int numberCompletedProjects) {
        this.numberCompletedProjects = numberCompletedProjects;
    }

    /**
     * Method to change the number of the current projects
     * @param numberApply Number to apply
     */
    public void changeNumberCurrentProjects(int numberApply) {
        numberCurrentProjects += numberApply;
    }

    /**
     * Method to change the number of the completed projects
     * @param numberApply Number to apply
     */
    public void changeNumberCompletedProjects(int numberApply) {
        numberCompletedProjects += numberApply;
    }

    /**
     * Method to assign a technician to a department
     * @param technician Technician to assign
     */
    @Override
    public void assignDepartmentTechnician(Technician technician) {
        super.getassociatedDepartment().getTechniciansList().add(technician);
    }

    /**
     * Method to disassociate a technician to a department
     * @param technician Technician to disassociate
     */
    @Override
    public void disassociateDepartmentTechnician(Technician technician) {
        super.getassociatedDepartment().getTechniciansList().remove(technician);
    }

    /**
     * Method to contribute
     */
    @Override
    public void contribute() {
        System.out.println("Contribute to Manager");
    }
}
