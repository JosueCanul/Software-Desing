package org.example.controllers;

import org.example.daos.UserDao;
import org.example.encryption.Desencriptar;
import org.example.encryption.Encriptar;
import org.example.encryption.Security;
import org.example.exceptions.CustomException;
import org.example.exceptions.LoginExceptions;
import org.example.models.User;

public class LoginUserController {
    Desencriptar desencriptar;
    Encriptar encriptar;

    UserDao userDao;

    LoginExceptions loginExceptions;
    public LoginUserController(){
        desencriptar = new Security();
        encriptar = new Security();
        userDao = new UserDao();
        loginExceptions = new LoginExceptions();
    }

    public void registerUser(User user){
        user.setPassword(encriptar.encriptar(user.getPassword()));
        userDao.setUser(user);
    }

    public void loginUser(String email, String password) {

        try{
            User user = loginExceptions.userNotFound(userDao.returnUsers(), email);
            loginExceptions.passwordIsNotCorrect(password, desencriptar.desencriptar(user.getPassword()));
            System.out.println("Happy Path");

        }catch (CustomException e){
            System.out.println(e);
        }

    }


}
