package org.example.daos;

import org.example.dataread.LecturaArchivo;
import org.example.dataread.LecturaCSV;
import org.example.datawrite.EscrituraArchivo;
import org.example.datawrite.EscrituraCSV;
import org.example.models.User;

import java.util.ArrayList;

public class UserDao {
    private String direction = "users.cvs";
    private final EscrituraArchivo escrituraArchivo;

    private final LecturaArchivo lecturaArchivo;

    public UserDao() {
        this.escrituraArchivo = new EscrituraCSV();
        this.lecturaArchivo = new LecturaCSV("users.csv");
    }

    public ArrayList<User> returnUsers(){
        String[][] users = lecturaArchivo.getRecords();
        ArrayList<User> usersArrayList = new ArrayList<>();
        for(int rows = 0; rows < users.length; rows++){
            User user = new User(users[rows][0], users[rows][1]);
            usersArrayList.add(user);
        }
        return  usersArrayList;
    }
    public void setUsers(ArrayList<User> usersForSet){
        ArrayList<User> usersFile = returnUsers();
        for(User user: usersForSet){
            usersFile.add(user);
        }
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        ArrayList<User> users = userDao.returnUsers();

        for(User user: users ){
            System.out.println(user.toString());
        }
    }
}
