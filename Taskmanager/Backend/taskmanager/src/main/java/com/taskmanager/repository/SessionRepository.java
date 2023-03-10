package com.taskmanager.repository;

import com.taskmanager.model.SessionManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface SessionRepository extends JpaRepository<SessionManagement, UUID> {

}
