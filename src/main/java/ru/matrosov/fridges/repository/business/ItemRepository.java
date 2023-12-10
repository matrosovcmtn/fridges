package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.ItemModel;

import java.util.List;

public interface ItemRepository {
    List<ItemModel> findAll();

    ItemModel findById(Integer id);

    List<ItemModel> findAllAsc();

    List<ItemModel> findAllDesc();

    List<ItemModel> findAllFiltered(Integer min, Integer max);

    List<ItemModel> findAllSearched(String query);
}
