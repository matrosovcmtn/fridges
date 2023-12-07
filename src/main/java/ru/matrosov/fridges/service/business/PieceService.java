package ru.matrosov.fridges.service.business;

import ru.matrosov.fridges.model.dictionary.PieceModel;

import java.util.List;

public interface PieceService {
    List<PieceModel> findAll();

    PieceModel findById(Integer id);
}
