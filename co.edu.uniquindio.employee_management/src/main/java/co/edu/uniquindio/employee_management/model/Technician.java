package co.edu.uniquindio.employee_management.model;

import java.util.LinkedList;

public class Technician extends Employee{
    private TechnicianRole technicianRole;

    /**
     * Method constructor for the class Technician
     * @param name Name of the technician to create
     * @param id ID of the technician to create
     * @param department Department of the technician to create
     * @param technicianRole Role of the technician to create
     */
    public Technician(String name, String id, Department department, TechnicianRole technicianRole) {
        super(name, id, department);
        this.technicianRole = technicianRole;
    }

    /**
     * Method to obtain the technician's role
     * @return Technician's role
     */
    public TechnicianRole getTechnicianRole() {
        return technicianRole;
    }

    /**
     * Method to modify the technician's role
     * @param technicianRole New role of the technician
     */
    public void setTechnicianRole(TechnicianRole technicianRole) {
        this.technicianRole = technicianRole;
    }

    /**
     * Method to contribute
     */
    @Override
    public void contribute() {
        System.out.println("Contribute to Technician");
    }
}
