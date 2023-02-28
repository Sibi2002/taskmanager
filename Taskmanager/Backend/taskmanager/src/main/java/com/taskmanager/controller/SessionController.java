package com.taskmanager.controller;
import com.taskmanager.Enum.Roles;
import com.taskmanager.dto.Sessiondto;
import com.taskmanager.model.SessionManagement;
import com.taskmanager.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000" ,allowCredentials = "true",methods = {RequestMethod.POST,RequestMethod.GET})
public class SessionController {
    @Autowired
    private SessionService service;
    @GetMapping ("/api/deletesession")
    public  void delete( @CookieValue(name = "username",defaultValue = "noauth") String uuid ) {
        if (!uuid.equals("noauth")){
            UUID id = UUID.fromString(uuid);
        service.deleteById(id);
    }
    }
    @GetMapping("/api/verify")
    public Sessiondto verifyAuth(@CookieValue(name = "username", defaultValue = "noauth") String uuid){
        if(!uuid.equals("noauth")){

        UUID id=UUID.fromString(uuid);
        SessionManagement authorized=service.getAuth(id);
         if(authorized!=null){
           return new Sessiondto(Roles.fromValue(authorized.getRole_id()),authorized.getUser_name());
         }
        }
         return null;
    }
}
