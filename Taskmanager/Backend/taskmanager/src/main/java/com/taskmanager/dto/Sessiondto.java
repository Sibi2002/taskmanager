package com.taskmanager.dto;

import com.taskmanager.Enum.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Sessiondto {
   private Roles role;
   private  String user_name;
}
