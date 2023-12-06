package ru.matrosov.fridges.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "warehouse")
public class Warehouse {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "warehouse_information")
    private String warehouse_information;

    @Column(name = "details_information")
    private String details_information;
}
