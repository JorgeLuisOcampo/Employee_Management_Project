package co.edu.uniquindio.employee_management;

import co.edu.uniquindio.employee_management.factory.ModelFactory;
import co.edu.uniquindio.employee_management.model.ManagementCompany;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        ModelFactory.initializeData();
        ManagementCompany managementCompany = modelFactory.getManagementCompany();
        System.out.println(managementCompany.getManagerList().size());
    }
}