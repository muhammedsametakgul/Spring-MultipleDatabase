package com.sametakgul.multiple_db.repository.mysql;

import com.sametakgul.multiple_db.model.mysql.MySQLUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MySQLUserRepository extends JpaRepository<MySQLUser, Integer> {
}
