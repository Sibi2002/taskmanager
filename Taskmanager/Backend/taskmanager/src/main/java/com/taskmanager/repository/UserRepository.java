package com.taskmanager.repository;

import com.taskmanager.dto.UserDto;
import com.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select user_id,user_name from users",nativeQuery = true)
         List<UserDto> getAllUser();
    @Query(value = "select * from users where user_name= ?1",nativeQuery = true)
     User getUserByName(String name);
}
