package co.edu.uniquindio.employee_management.mapping.dto;

import co.edu.uniquindio.employee_management.model.Manager;
import co.edu.uniquindio.employee_management.model.Project;
import co.edu.uniquindio.employee_management.model.Technician;

import java.util.LinkedList;

public record DepartmentDto(
        String name,
        int code,
        Project associatedProject,
        Manager managerAssociated,
        LinkedList<Technician> techniciansList
) {
}
