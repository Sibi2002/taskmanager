package com.taskmanager.repository;
import com.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(value = "select * from tasks where task_name=?1", nativeQuery = true)
    Task getTaskByName(String name);
}
