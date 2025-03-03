package co.edu.uniquindio.employee_management.model;

public class Technician extends Employee{
    /**
     * Method constructor for the class Technician
     * @param name Name of the technician to create
     * @param id ID of the technician to create
     * @param department Department of the technician to create
     */
    public Technician(String name, String id, Department department) {
        super(name, id, department);
    }

    /**
     * Method to contribute
     */
    @Override
    public void contribute() {
        System.out.println("The technician " + getName() + " has been contributed to the project.");
    }
}