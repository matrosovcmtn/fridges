package ru.matrosov.fridges.service.business;

import ru.matrosov.fridges.model.dictionary.DetailModel;

import java.util.List;

public interface DetailService {
    List<DetailModel> findAll();

    DetailModel findById(Integer id);
}
