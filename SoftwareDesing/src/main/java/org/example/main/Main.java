package org.example.main;

import org.example.dataread.LecturaCSV;
import org.example.daos.StudentDao;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        /*FileWriter fileWriter = new FileWriter("prueba.csv");
        fileWriter.write("dasdsa");
        fileWriter.close();

        */
        LecturaCSV lecturaCSV = new LecturaCSV();
        String[][] records = lecturaCSV.getRecords();

        for (String[] i : records){
            for (String e : i){
                System.out.println(e);
            }
        }

        StudentDao studentDao = new StudentDao();

        /*ArrayList<Student> students = studentDao.readStudents();
        for(Student student : students){
            System.out.println(student.toString());
        }*/

        int[] updatedRecords = {85,90};
        studentDao.updateStudentsRecords(updatedRecords);

        for (String[] i : records){
            for (String e : i){
                System.out.println(e);
            }
        }
        

    }
}