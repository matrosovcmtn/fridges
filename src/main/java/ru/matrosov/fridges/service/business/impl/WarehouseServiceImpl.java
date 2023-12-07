package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.WarehouseModel;
import ru.matrosov.fridges.repository.business.WarehouseRepository;
import ru.matrosov.fridges.service.business.WarehouseService;

import java.util.List;

@AllArgsConstructor
@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;

    @Transactional
    @Override
    public List<WarehouseModel> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public WarehouseModel findById(Integer id) {
        return repository.findById(id);
    }
}
