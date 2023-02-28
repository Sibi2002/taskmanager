package com.taskmanager.utils;
import com.taskmanager.model.SessionManagement;
import com.taskmanager.model.User;
import com.taskmanager.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import java.util.UUID;
@Component
public class Generator {
     public SessionManagement getSessionManagement( User user){
          UUID uuid= UUID.randomUUID();
          SessionManagement sessionManagement=new SessionManagement();
          sessionManagement.setId(uuid);
          sessionManagement.setUser_id(user.getUser_id());
          sessionManagement.setRole_id(user.getRole_id());
          sessionManagement.setUser_name(user.getUser_name());
          return sessionManagement;
     }
     public Cookie getCookie(SessionManagement sessionManagement){
          String id=sessionManagement.getId().toString();
          System.out.println(sessionManagement.getId());
          Cookie cookie = new Cookie("username",id);
          cookie.setHttpOnly(true);
          cookie.setPath("/");
          return cookie;
     }
}
