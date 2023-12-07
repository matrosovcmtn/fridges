package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.PieceModel;
import ru.matrosov.fridges.repository.business.PieceRepository;
import ru.matrosov.fridges.service.business.PieceService;

import java.util.List;

@AllArgsConstructor
@Service
public class PieceServiceImpl implements PieceService {
    private final PieceRepository repository;

    @Transactional
    @Override
    public List<PieceModel> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public PieceModel findById(Integer id) {
        return repository.findById(id);
    }
}
