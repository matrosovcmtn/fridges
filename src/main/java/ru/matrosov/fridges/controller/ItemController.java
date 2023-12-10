package ru.matrosov.fridges.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.matrosov.fridges.model.dictionary.ItemModel;
import ru.matrosov.fridges.service.business.ItemService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    /**
     * Method returns list of items
     * POST - /item/getAll
     *
     * @return ResponseEntity<List < ItemModel>> - list of items
     */
    @PostMapping("/getAll")
    public ResponseEntity<List<ItemModel>> getAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    /**
     * Method returns item by id
     * POST - /item/getById
     *
     * @param id - employee's identifier
     * @return ResponseEntity<ItemModel> - found item
     */
    @PostMapping("/getById/{id}")
    public ResponseEntity<ItemModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @PostMapping("/getAll/desc")
    public ResponseEntity<List<ItemModel>> getAllDesc() {
        return ResponseEntity.ok(itemService.findAllDesc());
    }

    @PostMapping("/getAll/asc")
    public ResponseEntity<List<ItemModel>> getAllAsc() {
        return ResponseEntity.ok(itemService.findAllAsc());
    }

    @PostMapping("/getAllFiltered")
    public ResponseEntity<List<ItemModel>> getAllAsc(
            @RequestParam(value = "min") Integer min,
            @RequestParam(value = "max") Integer max
    ) {
        return ResponseEntity.ok(itemService.getAllFiltered(min, max));
    }

    @PostMapping("/getAllSearched")
    public ResponseEntity<List<ItemModel>> getAllAsc(
            @RequestParam(value = "query") String query
    ) {
        return ResponseEntity.ok(itemService.getAllSearched(query));
    }
}