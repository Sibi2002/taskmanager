package com.taskmanager.controller;

import com.taskmanager.dto.UserDto;
import com.taskmanager.model.SessionManagement;
import com.taskmanager.model.User;
import com.taskmanager.service.SessionService;
import com.taskmanager.service.UserService;
import com.taskmanager.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Generator generator;
    @Autowired
    private SessionService sessionRepository;


    @PostMapping("/login")
    public ResponseEntity<String> getUserForAccess(@RequestBody User user, HttpServletResponse httpServletResponse){
       User valid=userService.getUserForAccess(user.getUser_name());
       if(valid!=null && user.getUser_name().equals(valid.getUser_name()) && user.getPassword().equals(valid.getPassword())){
             SessionManagement sessionManagement=generator.getSessionManagement(valid);

             sessionRepository.save(sessionManagement);
             Cookie cookie =generator.getCookie(sessionManagement);
             httpServletResponse.addCookie(cookie);
             String LogIn="Login Successful";
            return ResponseEntity.ok().body(LogIn);
       }
       String LogIn="Login Failed";
      return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(LogIn);
    }
    @PostMapping("/signup")
    public ResponseEntity <String> postUser(@RequestBody User user,HttpServletResponse httpServletResponse){
       int access=  userService.postUser(user);
        if(access==1) {
            User valid=userService.getUserForAccess(user.getUser_name());
        SessionManagement sessionManagement=generator.getSessionManagement(valid);
        sessionRepository.save(sessionManagement);
        Cookie cookie =generator.getCookie(sessionManagement);
        httpServletResponse.addCookie(cookie);
        String Signup="SignUp Successful";
            return ResponseEntity.ok().body(Signup);
        }
        String Signup="Sign Up Failed";
       return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(Signup);
    }
    @GetMapping("/api/admin/allusers")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }
}
