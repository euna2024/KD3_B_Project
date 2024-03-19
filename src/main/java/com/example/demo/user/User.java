package com.example.demo.user;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String userID;
    private String email;
    private String password;
    private String userName;
    private Date date;
    
}
