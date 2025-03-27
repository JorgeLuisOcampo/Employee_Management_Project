package co.edu.uniquindio.employee_management.mapping.mappers;

import co.edu.uniquindio.employee_management.model.Department;
import co.edu.uniquindio.employee_management.mapping.dto.DepartmentDto;
import co.edu.uniquindio.employee_management.services.IDepartmentMapping;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMappingImpl implements IDepartmentMapping {

    @Override
    public List<DepartmentDto> getDepartmentsDto(List<Department> departmentsList) {
        if (departmentsList == null){
            return  null;
        }
        List<DepartmentDto> departmentsDtoList= new ArrayList<DepartmentDto>(departmentsList.size());
        for (Department department : departmentsList){
            departmentsDtoList.add(departmentToDepartmentDto(department));
        }
        return departmentsDtoList;
    }

    @Override
    public DepartmentDto departmentToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getName(),
                department.getCode(),
                department.getAssociatedProject(),
                department.getManagerAssociated(),
                department.getTechniciansList()
                );
    }

    @Override
    public Department departmentDtoToDeparment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.name());
        department.setCode(departmentDto.code());
        department.setAssociatedProject(departmentDto.associatedProject());
        department.setManagerAssociated(departmentDto.managerAssociated());
        department.setTechniciansList(departmentDto.techniciansList());
        return department;
    }

}