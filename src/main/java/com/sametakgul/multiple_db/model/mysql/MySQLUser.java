package com.sametakgul.multiple_db.model.mysql;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MySQLUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
