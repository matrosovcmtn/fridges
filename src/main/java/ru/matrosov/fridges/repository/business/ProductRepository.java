package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.ProductModel;

import java.util.List;

public interface ProductRepository {
    List<ProductModel> findAll();

    ProductModel findById(Integer id);
}
