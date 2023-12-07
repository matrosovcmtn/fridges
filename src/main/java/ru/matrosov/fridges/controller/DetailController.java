package ru.matrosov.fridges.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matrosov.fridges.model.dictionary.DetailModel;
import ru.matrosov.fridges.service.business.DetailService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/detail")
public class DetailController {
    private final DetailService detailService;

    /**
     * Method returns list of details
     * POST - /detail/getAll
     *
     * @return ResponseEntity<List<DetailModel>> - list of details
     */
    @PostMapping("/getAll")
    public ResponseEntity<List<DetailModel>> getAll() {
        return ResponseEntity.ok(detailService.findAll());
    }

    /**
     * Method returns detail by id
     * POST - /detail/getById
     *
     * @param id - employee's identifier
     * @return ResponseEntity<DetailModel> - found detail
     */
    @PostMapping("/getById/{id}")
    public ResponseEntity<DetailModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(detailService.findById(id));
    }
}
