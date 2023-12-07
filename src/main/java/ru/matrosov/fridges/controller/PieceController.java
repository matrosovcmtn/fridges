package ru.matrosov.fridges.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matrosov.fridges.model.dictionary.PieceModel;
import ru.matrosov.fridges.service.business.PieceService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/piece")
public class PieceController {
    private final PieceService pieceService;

    /**
     * Method returns list of pieces
     * POST - /piece/getAll
     *
     * @return ResponseEntity<List<PieceModel>> - list of pieces
     */
    @PostMapping("/getAll")
    public ResponseEntity<List<PieceModel>> getAll() {
        return ResponseEntity.ok(pieceService.findAll());
    }

    /**
     * Method returns piece by id
     * POST - /piece/getById
     *
     * @param id - employee's identifier
     * @return ResponseEntity<PieceModel> - found piece
     */
    @PostMapping("/getById/{id}")
    public ResponseEntity<PieceModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pieceService.findById(id));
    }
}
