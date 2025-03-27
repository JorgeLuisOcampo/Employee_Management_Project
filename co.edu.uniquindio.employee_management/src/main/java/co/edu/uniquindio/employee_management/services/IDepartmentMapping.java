package co.edu.uniquindio.employee_management.services;

import co.edu.uniquindio.employee_management.mapping.dto.DepartmentDto;
import co.edu.uniquindio.employee_management.model.Department;

import java.util.List;

public interface IDepartmentMapping {
    List<DepartmentDto> getDepartmentsDto(List<Department> departmentsList);
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDeparment(DepartmentDto departmentDto);
}
