package ru.matrosov.fridges.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matrosov.fridges.model.dictionary.WarehouseModel;
import ru.matrosov.fridges.service.business.WarehouseService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    /**
     * Method returns list of warehouses
     * POST - /warehouse/getAll
     *
     * @return ResponseEntity<List<WarehouseModel>> - list of warehouses
     */
    @PostMapping("/getAll")
    public ResponseEntity<List<WarehouseModel>> getAll() {
        return ResponseEntity.ok(warehouseService.findAll());
    }

    /**
     * Method returns warehouse by id
     * POST - /warehouse/getById
     *
     * @param id - employee's identifier
     * @return ResponseEntity<WarehouseModel> - found warehouse
     */
    @PostMapping("/getById/{id}")
    public ResponseEntity<WarehouseModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(warehouseService.findById(id));
    }
}
