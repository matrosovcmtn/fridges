package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.PieceModel;

import java.util.List;

public interface PieceRepository {
    List<PieceModel> findAll();

    PieceModel findById(Integer id);
}
