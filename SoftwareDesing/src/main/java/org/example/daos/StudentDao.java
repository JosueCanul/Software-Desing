package org.example.daos;

import org.example.dataread.LecturaCSV;
import org.example.datawrite.EscrituraCSV;
import org.example.models.Student;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentDao {

    private String direction = "record.csv";
    private LecturaCSV lecturaCSV;
    private EscrituraCSV escrituraCSV;
    public StudentDao(){
        this.lecturaCSV = new LecturaCSV(direction);
        this.escrituraCSV = new EscrituraCSV(direction);
    }

    public  StudentDao(String direction){
        this.direction = direction;
    }

    public void updateStudentsRecords(int[] updatedRecords){
        int record = 0;
        ArrayList<Student> students = readStudents();
        for (Student student : students){
            if(updatedRecords[record] <= 100 || updatedRecords[record] >= 0)
                student.setCalificacion(updatedRecords[record]);
            record++;
        }
        escrituraCSV.setDataCsv(students);
    }

    public ArrayList<Student>  readStudents(){
        String[][] studentsRecords = lecturaCSV.getRecords();
        ArrayList<Student> students = new ArrayList<>();

        for(int rows = 0; rows < studentsRecords.length; rows++){
            Student student = new Student(studentsRecords[rows][1], studentsRecords[rows][2],
                    studentsRecords[rows][3], Long.valueOf(studentsRecords[rows][4]), Integer.valueOf(studentsRecords[rows][5]));
            students.add(student);
        }

        return students;
    }

    public void setRecordsSimplifiedCSV(String dt){
        String direction = dt + ".csv";
        ArrayList<Student> students = readStudents();
        try (PrintWriter printWriter = new PrintWriter(new File(direction))){
            for (Student student : students){
                printWriter.println(student.getMatricula() + "," + student.getMateria() + "," + student.getCalificacion());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void setAllStudents(ArrayList<Student> students){
        escrituraCSV.setDataCsv(students);
    }

}
