package co.edu.uniquindio.employee_management.services;

import co.edu.uniquindio.employee_management.mapping.dto.DepartmentDto;

import java.util.List;

public interface IModelFactoryService {
    List<DepartmentDto> getDepartmentsDto();
}
