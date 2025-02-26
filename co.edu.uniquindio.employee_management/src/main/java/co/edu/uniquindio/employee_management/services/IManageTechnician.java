package co.edu.uniquindio.employee_management.services;

import co.edu.uniquindio.employee_management.model.Technician;

public interface IManageTechnician {
    void assignDepartmentTechnician(Technician technician);
    void disassociateDepartmentTechnician(Technician technician);
}