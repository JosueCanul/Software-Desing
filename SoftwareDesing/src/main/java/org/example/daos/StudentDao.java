package org.example.daos;

import org.example.dataread.LecturaCSV;
import org.example.datawrite.EscrituraCSV;
import org.example.models.Student;

import java.util.ArrayList;

public class StudentDao {

    private LecturaCSV lecturaCSV;
    private EscrituraCSV escrituraCSV;
    public StudentDao(){
        this.lecturaCSV = new LecturaCSV();
        this.escrituraCSV = new EscrituraCSV();
    }

    public  StudentDao(String direction){
        this.lecturaCSV = new LecturaCSV();
        this.escrituraCSV = new EscrituraCSV(direction);
    }

    public void updateStudentsRecords(int[] updatedRecords){
        int record = 0;
        ArrayList<Student> students = readStudents();
        for (Student student : students){
            if(updatedRecords[record] <= 100 || updatedRecords[record] >= 0)
                student.setCalificacion(updatedRecords[record]);
            record++;
        }
        escrituraCSV.setRecords(students);
    }

    private ArrayList<Student>  readStudents(){
        String[][] studentsRecords = lecturaCSV.getRecords();
        ArrayList<Student> students = new ArrayList<>();

        for(int rows = 0; rows < studentsRecords.length; rows++){
            Student student = new Student(studentsRecords[rows][1], studentsRecords[rows][2],
                    studentsRecords[rows][3], Long.valueOf(studentsRecords[rows][4]), Integer.valueOf(studentsRecords[rows][5]));
            students.add(student);
        }

        return students;
    }

    public void setStudentRecordsSimplified(){
        escrituraCSV.setRecordsSimplified(readStudents());
    }
}
