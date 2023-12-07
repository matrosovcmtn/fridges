package ru.matrosov.fridges.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matrosov.fridges.model.dictionary.EmployeeModel;
import ru.matrosov.fridges.service.business.EmployeeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * Method returns list of employers
     * POST - /employee/getAll
     *
     * @return ResponseEntity<List<EmployeeModel>> - list of employers
     */
    @PostMapping("/getAll")
    public ResponseEntity<List<EmployeeModel>> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    /**
     * Method returns employee by id
     * POST - /employee/getById
     *
     * @param id - employee's identifier
     * @return ResponseEntity<EmployeeModel> - found employee
     */
    @PostMapping("/getById/{id}")
    public ResponseEntity<EmployeeModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }
}
