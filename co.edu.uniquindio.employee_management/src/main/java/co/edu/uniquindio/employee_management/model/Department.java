package co.edu.uniquindio.employee_management.model;

import java.util.LinkedList;

public class Department {
    private String name;
    private int code;
    private LinkedList<Employee> employeesList;

    /**
     * Method constructor for the class Department
     * @param name Name of the department to create
     * @param code Code of the department to create
     */
    public Department(String name, int code) {
        this.name = name;
        this.code = code;
        this.employeesList = new LinkedList<>();
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
     * Method to obtain the list of employees in the department
     * @return List of employees in the department
     */
    public LinkedList<Employee> getEmployeesList() {
        return employeesList;
    }

    /**
     * Method to modify the list of employees in the department
     * @param employeesList New list of employees
     */
    public void setEmployeesList(LinkedList<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}
