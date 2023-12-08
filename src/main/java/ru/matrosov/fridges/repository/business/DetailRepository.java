package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.DetailModel;

import java.util.List;

public interface DetailRepository {
    List<DetailModel> findAll();

    DetailModel findById(Integer id);
}
