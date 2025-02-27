package co.edu.uniquindio.employee_management.factory;

import co.edu.uniquindio.employee_management.model.Department;
import co.edu.uniquindio.employee_management.model.ManagementCompany;
import co.edu.uniquindio.employee_management.model.Manager;
import co.edu.uniquindio.employee_management.model.Technician;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private static ManagementCompany managementCompany;

    private ModelFactory() {
        initializeData();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public static void initializeData() {
        managementCompany = new ManagementCompany("UQ Software");
        Department department = new Department("Bloque 1", 1);
        Department department2 = new Department("Bloque 2", 2);
        Technician technician = new Technician("Alejo", "20", department);
        Technician technician1 = new Technician("Alejo", "21", department);
        Manager manager = new Manager("Vero", "22", department);
        Manager manager1 = new Manager("Vero", "23", department2);
        managementCompany.addEmployee(technician);
        managementCompany.addEmployee(technician1);
        managementCompany.addEmployee(manager1);
        managementCompany.addEmployee(manager);
    }

    public ManagementCompany getManagementCompany() {
        return managementCompany;
    }
}
