package co.edu.uniquindio.employee_management.services;

public interface IManageTechnician {
    void associateProjectTechnician(int code, String id);
    void disassociateProjectTechnician(int code, String id);
}