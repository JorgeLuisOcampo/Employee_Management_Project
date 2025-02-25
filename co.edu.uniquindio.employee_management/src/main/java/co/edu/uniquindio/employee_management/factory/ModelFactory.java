package co.edu.uniquindio.employee_management.factory;

import co.edu.uniquindio.employee_management.model.ManagementCompany;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private ManagementCompany managementCompany;

    private ModelFactory() {
        initializeData();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void initializeData() {
        managementCompany = new ManagementCompany("UQ Software");
    }

    public ManagementCompany getManagementCompany() {
        return managementCompany;
    }
}
