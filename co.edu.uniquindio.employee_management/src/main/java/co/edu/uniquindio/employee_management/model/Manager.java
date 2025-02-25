package co.edu.uniquindio.employee_management.model;

public class Manager extends  Employee{
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

    public void changeNumberCurrentProjects(int numberApply) {
        numberCurrentProjects += numberApply;
    }

    public void changeNumberCompletedProjects(int numberApply) {
        numberCompletedProjects += numberApply;
    }

    public void createProject() {

    }

    /**
     * Method to contribute
     */
    @Override
    public void contribute() {
        System.out.println("Contribute to Manager");
    }
}
