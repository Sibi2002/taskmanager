package com.taskmanager.service;
import com.taskmanager.dto.UserDto;
import com.taskmanager.model.User;
import com.taskmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
// why all args const
public class UserService {

    @Autowired
    private UserRepository userDao;

    public int postUser(User user){
        if(userDao.getUserByName(user.getUser_name())!=null){
           return 0;
        }
        userDao.save(user);
        return 1;
    }
    public User getUserForAccess(String user_name){
        return userDao.getUserByName(user_name);
    }
    public List<UserDto> getAllUsers(){
        return userDao.getAllUser();
    }
}
