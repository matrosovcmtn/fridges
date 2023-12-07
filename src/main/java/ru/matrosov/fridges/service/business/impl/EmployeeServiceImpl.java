package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.EmployeeModel;
import ru.matrosov.fridges.repository.business.EmployeeRepository;
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

    @Transactional
    @Override
    public EmployeeModel findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public int add(EmployeeModel employee) {
        return repository.save(employee);
    }
}
