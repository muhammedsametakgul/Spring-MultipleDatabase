package com.sametakgul.multiple_db.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class PostgreSQLUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
