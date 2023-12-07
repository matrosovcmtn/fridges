package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.EmployeeModel;
import ru.matrosov.fridges.repository.EmployeeRepository;
import ru.matrosov.fridges.service.business.EmployeeService;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Transactional
    @Override
    public List<EmployeeModel> findAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeModel findById(Integer id) {
        return repository.findById(id);
    }
}
