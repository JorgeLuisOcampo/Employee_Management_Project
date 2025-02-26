package co.edu.uniquindio.employee_management.model;

import java.util.LinkedList;

public class Project {
    private String name;
    private int code;
    private boolean completed;
    private LinkedList<Employee> assignedEmployeesList;
    private LinkedList<Department> departmentsList;

    /**
     * Method constructor for the class Project
     * @param name Name of the project to create
     * @param code Code of the project to create
     */
    public Project(String name, int code) {
        this.name = name;
        this.code = code;
        this.completed = false;
        this.assignedEmployeesList = new LinkedList<>();
        this.departmentsList = new LinkedList<>();
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
     * Method to obtain the project's assigned employees list
     * @return Project's assigned employees list
     */
    public LinkedList<Employee> getAssignedEmployeesList() {
        return assignedEmployeesList;
    }

    /**
     * Method to modify the project's assigned employees list
     * @param assignedEmployeesList New assigned employees list of the project
     */
    public void setAssignedEmployeesList(LinkedList<Employee> assignedEmployeesList) {
        this.assignedEmployeesList = assignedEmployeesList;
    }

    /**
     * Method to obtain the project's departments list
     * @return Project's departments list
     */
    public LinkedList<Department> getDepartmentsList() {
        return departmentsList;
    }

    /**
     * Method to modify the project's departments list
     * @param departmentsList New departments list of the project
     */
    public void setDepartmentsList(LinkedList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }
}