package co.edu.uniquindio.employee_management;

import co.edu.uniquindio.employee_management.factory.ModelFactory;
import co.edu.uniquindio.employee_management.mapping.dto.DepartmentDto;
import co.edu.uniquindio.employee_management.model.ManagementCompany;
import co.edu.uniquindio.employee_management.model.Project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        createDepartment(modelFactory);
        System.out.println(modelFactory.getManagementCompany().getDepartmentsList().size());
    }

    public static void createDepartment(ModelFactory modelFactory) {
        DepartmentDto departmentDto = new DepartmentDto("Bonice", 1, null, null, null);
        modelFactory.createDepartment(departmentDto);
    }

    public static void currentProjectsMostEmployees(ModelFactory modelFactory) {
        String projectName = modelFactory.currentProjectMostEmployees();
        if (projectName.isEmpty()) {
            System.out.println("No hay ningún proyecto en proceso con empleados");
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
            System.out.println("El departamento: " + departmentName + ", es el departamento con más técnicos");
        }
    }
}