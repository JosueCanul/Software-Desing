package org.example.datawrite;

import org.example.models.Student;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscrituraCSV<E> implements EscrituraArchivo {
    private String direction = "record.csv";

    public EscrituraCSV(){

    }
    public EscrituraCSV(String direction){
        File file = new File(direction);
        this.direction = direction;
    }


    public void setRecords(ArrayList<Student> updatedStudents){
        try (PrintWriter printWriter = new PrintWriter(new File(direction))){
            for (Student student : updatedStudents){
                printWriter.println(student.toString());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void setRecordsSimplified(ArrayList<Student> updatedStudents){
        try (PrintWriter printWriter = new PrintWriter(new File(direction))){
            for (Student student : updatedStudents){
                printWriter.println(student.getMatricula() + "," + student.getMateria() + "," + student.getCalificacion());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
