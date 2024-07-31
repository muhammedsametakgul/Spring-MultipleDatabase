package com.sametakgul.multiple_db.repository.postgresql;

import com.sametakgul.multiple_db.model.postgresql.PostgreSQLUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreSQLUserRepository extends JpaRepository<PostgreSQLUser, Long> {
}
