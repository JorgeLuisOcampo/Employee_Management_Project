package co.edu.uniquindio.employee_management.model;
import co.edu.uniquindio.employee_management.services.IContributor;

public abstract class Employee implements IContributor {
    private String name;
    private String id;
    private Department associatedDepartment;
    private Project associatedProject;

    /**
     * Method constructor for the class Employee
     * @param name Name of the employee to create
     * @param id ID of the employee to create
     * @param department Department of the employee to create
     */
    public Employee(String name, String id, Department department) {
        this.name = name;
        this.id = id;
        this.associatedDepartment = department;
    }

    /**
     * Method to obtain the Employee's name
     * @return Employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to modify the Employee's name
     * @param name New name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to obtain the Employee's ID
     * @return Employee's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Method to modify the Employee's ID
     * @param id New ID of the employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to obtain the Employee's associated department
     * @return Employee's associated department
     */
    public Department getassociatedDepartment() {
        return associatedDepartment;
    }

    /**
     * Method to modify the Employee's associated department
     * @param department New department of the employee
     */
    public void setAssociatedDepartment(Department department) {
        this.associatedDepartment = department;
    }

    /**
     * Method to obtain the employee's associated project
     * @return Employee's associated project
     */
    public Project getAssociatedProject() {
        return associatedProject;
    }

    /**
     * Method to modify the employee's associated project
     * @param associatedProject New associated project of the employee
     */
    public void setAssociatedProject(Project associatedProject) {
        this.associatedProject = associatedProject;
    }
}