package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.ItemModel;
import ru.matrosov.fridges.repository.business.ItemRepository;
import ru.matrosov.fridges.service.business.ItemService;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Transactional
    @Override
    public List<ItemModel> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public ItemModel findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<ItemModel> findAllDesc() {
        return repository.findAllDesc();
    }

    @Override
    public List<ItemModel> findAllAsc() {
        return repository.findAllAsc();
    }

    @Override
    public List<ItemModel> getAllFiltered(Integer min, Integer max) {
        return repository.findAllFiltered(min, max);
    }

    @Override
    public List<ItemModel> getAllSearched(String query) {
        return repository.findAllSearched(query);
    }
}
