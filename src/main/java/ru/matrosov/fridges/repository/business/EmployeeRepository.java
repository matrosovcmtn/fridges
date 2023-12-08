package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.EmployeeModel;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeModel> findAll();

    EmployeeModel findById(Integer id);

    int save(EmployeeModel employeeModel);
}
