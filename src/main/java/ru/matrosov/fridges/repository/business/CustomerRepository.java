package ru.matrosov.fridges.repository.business;

import ru.matrosov.fridges.model.dictionary.CustomerModel;

import java.util.List;

public interface CustomerRepository {
    List<CustomerModel> findAll();

    CustomerModel findById(Integer id);
}
