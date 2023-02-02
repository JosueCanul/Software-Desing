package org.example.exceptions;

import org.example.models.User;

import java.util.ArrayList;

public class LoginExceptions {
    public LoginExceptions(){ }

    public void passwordIsNotCorrect(String password, String string) throws CustomException{
        if(!password.equals(string)) throw new CustomException("Invalid Password");
    }

    public User userNotFound(ArrayList<User> users, String email)throws CustomException{
        boolean foundUser = false;
        User userFound = null;
        for(User user: users){
            if(user.getEmail().equals(email)){
                userFound = user;
                foundUser = true;
            }
        }

        if (foundUser == false)throw new CustomException("User not found");
        return  userFound;
    }
}
