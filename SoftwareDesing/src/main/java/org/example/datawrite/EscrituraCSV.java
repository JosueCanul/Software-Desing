package org.example.datawrite;

import org.example.models.Student;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscrituraCSV implements EscrituraArchivo {

    private String direction;


    public EscrituraCSV(String direction){
        File file = new File(direction);
        this.direction = direction;
    }


    public <E> void setDataCsv(ArrayList<E> items){
        try (PrintWriter printWriter = new PrintWriter(new File(direction))){

            for(E item: items){
                printWriter.append(item.toString() + "\n");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
