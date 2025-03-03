package co.edu.uniquindio.employee_management;

import co.edu.uniquindio.employee_management.factory.ModelFactory;
import co.edu.uniquindio.employee_management.model.ManagementCompany;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        ModelFactory.initializeData();
        ManagementCompany managementCompany = modelFactory.getManagementCompany();
        departmentMostTechnicians(modelFactory);
    }

    public static void currentProjectsMostEmployees(ModelFactory modelFactory) {
        String projectName = modelFactory.currentProjectMostEmployees();
        if (projectName.isEmpty()) {
            System.out.println("No hay ningún proyecto en proceso");
        }
        else {
            System.out.println("El proyecto: " + projectName + ", es el proyecto con más empleados");
        }
    }

    public static void departmentMostTechnicians(ModelFactory modelFactory) {
        String departmentName = modelFactory.departmentMostTechnicians();
        if (departmentName.isEmpty()) {
            System.out.println("No hay ningun departamento con técnicos");
        }
        else {
            System.out.println("El departamento: " + departmentName + ", es el departmento con más técnicos");
        }
    }
}