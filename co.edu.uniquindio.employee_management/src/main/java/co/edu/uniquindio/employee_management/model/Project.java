package co.edu.uniquindio.employee_management.model;

import java.util.LinkedList;

public class Project {
    private String name;
    private int code;
    private Manager associatedManager;
    private boolean completed;
    private LinkedList<Technician> techniciansList;

    /**
     * Method constructor for the class Project
     * @param name Name of the project to create
     * @param code Code of the project to create
     * @param associatedManager Manager associated with the project
     */
    public Project(String name, int code, Manager associatedManager) {
        this.name = name;
        this.code = code;
        this.associatedManager = associatedManager;
        this.completed = false;
        this.techniciansList = new LinkedList<>();
    }

    /**
     * Method to obtain the project's name
     * @return Project's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to modify the project's name
     * @param name New name of the project
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to obtain the project's code
     * @return Project's code
     */
    public int getCode() {
        return code;
    }

    /**
     * Method to modify the project's code
     * @param code New code of the project
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Method to obtain the manager associated with the project
     * @return Associated manager of the project
     */
    public Manager getAssociatedManager() {
        return associatedManager;
    }

    /**
     * Method to modify the manager associated with the project
     * @param associatedManager New manager associated with the project
     */
    public void setAssociatedManager(Manager associatedManager) {
        this.associatedManager = associatedManager;
    }

    /**
     * Method to check if the project is completed
     * @return True if the project is completed, otherwise false
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Method to modify the completed status of the project
     * @param completed New completed status of the project
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Method to obtain the list of technicians assigned to the project
     * @return List of technicians assigned to the project
     */
    public LinkedList<Technician> getTechniciansList() {
        return techniciansList;
    }

    /**
     * Method to modify the list of technicians assigned to the project
     * @param techniciansList New list of technicians assigned to the project
     */
    public void setTechniciansList(LinkedList<Technician> techniciansList) {
        this.techniciansList = techniciansList;
    }
}