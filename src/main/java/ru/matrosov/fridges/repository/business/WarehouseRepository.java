package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.WarehouseModel;

import java.util.List;

public interface WarehouseRepository {
    List<WarehouseModel> findAll();

    WarehouseModel findById(Integer id);
}
