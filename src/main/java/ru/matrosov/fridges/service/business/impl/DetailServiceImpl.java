package ru.matrosov.fridges.service.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.DetailModel;
import ru.matrosov.fridges.repository.business.DetailRepository;
import ru.matrosov.fridges.service.business.DetailService;

import java.util.List;

@AllArgsConstructor
@Service
public class DetailServiceImpl implements DetailService {
    private final DetailRepository repository;

    @Transactional
    @Override
    public List<DetailModel> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public DetailModel findById(Integer id) {
        return repository.findById(id);
    }
}
