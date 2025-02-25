package co.edu.uniquindio.employee_management.model;
import java.util.LinkedList;

public class ManagementCompany {
    private String name;
    private LinkedList<Department> departmentsList;
    private LinkedList<Employee> employeesList;
    private LinkedList<Project> projectsList;

    /**
     * Method constructor for the class ManagementCompany
     * @param name Name of the management company to create
     */
    public ManagementCompany(String name) {
        this.name = name;
        this.departmentsList = new LinkedList<>();
        this.employeesList = new LinkedList<>();
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

    /**
     * Method to obtain the list of employees in the management company
     * @return List of employees in the management company
     */
    public LinkedList<Employee> getEmployeesList() {
        return employeesList;
    }

    /**
     * Method to modify the list of employees in the management company
     * @param employeesList New list of employees
     */
    public void setEmployeesList(LinkedList<Employee> employeesList) {
        this.employeesList = employeesList;
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
            if (department.getCode() == code && department.getEmployeesList().isEmpty()) {
                departmentsList.remove(department);
                break;
            }
        }
    }

    /**
     * Method to assign an employee to the employeesList
     * @param employee Employee to create
     */
    public void createEmployee(Employee employee) {
        if (!verifyEmployee(employee.getId())){
            employeesList.add(employee);
            assignDepartmentEmployee(employee);
        }
    }

    /**
     * Method to verify if exists an employee with the same id as one given
     * @param id ID to verify
     * @return Boolean if the employee was found or not
     */
    public boolean verifyEmployee(String id) {
        boolean found = false;
        for (Employee employee : employeesList) {
            if (employee.getId().equals(id)) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Method to update an employee's information
     * @param id ID of the employee to update
     * @param newEmployee Employee with the new information
     */
    public void updateEmployee(String id, Employee newEmployee) {
        for (Employee employee : employeesList) {
            if (employee.getId().equals(id)) {
                if (!verifyEmployee(employee.getId()) || newEmployee.getId().equals(employee.getId())) {
                    employee.setName(newEmployee.getName());
                    employee.setId(newEmployee.getId());
                    updateDepartmentEmployee(employee, newEmployee);
                    break;
                }
            }
        }
    }

    /**
     * Method to delete an employee from the employeesList
     * @param id ID of the employee to delete
     */
    public void deleteEmployee(String id) {
        for (Employee employee : employeesList) {
            if (employee.getId().equals(id)) {
                employeesList.remove(employee);
                disassociateDepartmentEmployee(employee);
                break;
            }
        }
    }

    /**
     * Method to update an employee department
     * @param oldEmployee oldEmployee who we want to change its department
     * @param newEmployee newEmployee with the new department
     */
    public void updateDepartmentEmployee(Employee oldEmployee, Employee newEmployee) {
        if (oldEmployee.getassociatedDepartment().getCode() != newEmployee.getassociatedDepartment().getCode()) {
            disassociateDepartmentEmployee(oldEmployee);
            oldEmployee.setAssociatedDepartment(newEmployee.getassociatedDepartment());
            assignDepartmentEmployee(oldEmployee);
        }
    }

    /**
     * Method to assign an employee from a department
     * @param employee Employee to assign
     */
    public void assignDepartmentEmployee(Employee employee) {
        employee.getassociatedDepartment().getEmployeesList().add(employee);
    }

    /**
     * Method to disassociate an employee from a department
     * @param employee Employee to disassociate
     */
    public void disassociateDepartmentEmployee(Employee employee) {
        employee.getassociatedDepartment().getEmployeesList().remove(employee);
    }
}