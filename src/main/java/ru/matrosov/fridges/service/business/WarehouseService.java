package ru.matrosov.fridges.service.business;

import ru.matrosov.fridges.model.dictionary.WarehouseModel;

import java.util.List;

public interface WarehouseService {
    List<WarehouseModel> findAll();

    WarehouseModel findById(Integer id);
}
