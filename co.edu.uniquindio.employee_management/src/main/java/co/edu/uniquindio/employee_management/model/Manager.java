package co.edu.uniquindio.employee_management.model;

import co.edu.uniquindio.employee_management.services.IContributor;
import co.edu.uniquindio.employee_management.services.IManageTechnician;

public class Manager extends Employee implements IManageTechnician {
    private int numberCompletedProjects;

    /**
     * Method constructor for the class Manager
     * @param name Name of the manager to create
     * @param id ID of the manager to create
     * @param department Department of the manager to create
     */
    public Manager(String name, String id, Department department) {
        super(name, id, department);
        numberCompletedProjects = 0;
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
     * Method to change the number of the completed projects
     * @param numberApply Number to apply
     */
    public void changeNumberCompletedProjects(int numberApply) {
        this.numberCompletedProjects += numberApply;
    }

    /**
     * Method to contribute
     */
    @Override
    public void contribute() {
        System.out.println("Contribute to Manager");
    }

    /**
     * Method to associate a technician to a project
     * @param code Code of the project
     * @param id ID of the technician
     */
    @Override
    public void associateProjectTechnician(int code, String id) {
        if (code != getAssociatedProject().getCode() || getAssociatedProject().isCompleted()) {
            return;
        }
        for (Technician technician : super.getassociatedDepartment().getTechniciansList()) {
            if (technician.getId().equals(id)) {
                getAssociatedProject().getAssignedEmployeesList().add(technician);
                technician.setAssociatedProject(getAssociatedProject());
                return;
            }
        }
    }

    /**
     * Method to disassociate a technician to a project
     * @param code Code of the project
     * @param id ID of the technician
     */
    @Override
    public void disassociateProjectTechnician(int code, String id) {
        if (code != getAssociatedProject().getCode() || getAssociatedProject().isCompleted()) {
            return;
        }
        for (Technician technician : super.getassociatedDepartment().getTechniciansList()) {
            if (technician.getId().equals(id)) {
                getAssociatedProject().getAssignedEmployeesList().remove(technician);
                technician.setAssociatedProject(null);
                return;
            }
        }
    }
}
