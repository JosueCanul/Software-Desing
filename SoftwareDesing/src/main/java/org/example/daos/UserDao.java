package org.example.daos;

import org.example.dataread.LecturaArchivo;
import org.example.dataread.LecturaCSV;
import org.example.datawrite.EscrituraArchivo;
import org.example.datawrite.EscrituraCSV;
import org.example.models.User;

import java.util.ArrayList;

public class UserDao {
    private final String direction = "users.csv";
    private final EscrituraArchivo escrituraArchivo;

    private final LecturaArchivo lecturaArchivo;



    public UserDao() {
        this.escrituraArchivo = new EscrituraCSV(direction);
        this.lecturaArchivo = new LecturaCSV(direction);
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
        escrituraArchivo.setDataCsv(usersForSet);
    }

    public void setNewUsers(ArrayList<User> usersForSet){
        ArrayList<User> usersFromCSV = returnUsers();
        usersFromCSV.addAll(usersForSet);
        escrituraArchivo.setDataCsv(usersFromCSV);
    }
    public void setUser(User user){
        ArrayList<User> usersFromCSV = returnUsers();
        usersFromCSV.add(user);
        escrituraArchivo.setDataCsv(usersFromCSV);
    }
}
