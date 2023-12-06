package ru.matrosov.fridges.service.business;

import ru.matrosov.fridges.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    List<EmployeeModel> findAll();

    EmployeeModel findById(Integer id);
}
