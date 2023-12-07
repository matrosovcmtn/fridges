package ru.matrosov.fridges.service.business;

import ru.matrosov.fridges.model.dictionary.ItemModel;

import java.util.List;

public interface ItemService {
    List<ItemModel> findAll();

    ItemModel findById(Integer id);
}
