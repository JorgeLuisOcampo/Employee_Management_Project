package co.edu.uniquindio.employee_management.model;

import java.util.LinkedList;

public class Department {
    private String name;
    private int code;
    private Manager managerAssociated;
    private LinkedList<Technician> techniciansList;

    /**
     * Method constructor for the class Department
     * @param name Name of the department to create
     * @param code Code of the department to create
     * @param managerAssociated Manager of the department to create
     */
    public Department(String name, int code, Manager managerAssociated) {
        this.name = name;
        this.code = code;
        this.managerAssociated = managerAssociated;
        this.techniciansList = new LinkedList<>();
    }

    /**
     * Method to obtain the department's name
     * @return Department's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to modify the department's name
     * @param name New name of the department
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to obtain the department's code
     * @return Department's code
     */
    public int getCode() {
        return code;
    }

    /**
     * Method to modify the department's code
     * @param code New code of the department
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Method to obtain the department's manager associated
     * @return Department's manager associated
     */
    public Manager getManagerAssociated() {
        return managerAssociated;
    }

    /**
     * Method to modify the department's manager associated
     * @param managerAssociated New manager of the department
     */
    public void setManagerAssociated(Manager managerAssociated) {
        this.managerAssociated = managerAssociated;
    }

    /**
     * Method to obtain the department's technicians list
     * @return Department's technicians list
     */
    public LinkedList<Technician> getTechniciansList() {
        return techniciansList;
    }

    /**
     * Method to modify the department's technicians list
     * @param techniciansList New technicians list of the department
     */
    public void setTechniciansList(LinkedList<Technician> techniciansList) {
        this.techniciansList = techniciansList;
    }
}