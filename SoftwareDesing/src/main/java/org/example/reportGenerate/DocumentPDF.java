package org.example.reportGenerate;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TeXFragment;
import org.example.daos.StudentDao;
import org.example.models.Student;

import java.util.ArrayList;

public class DocumentPDF {
    private Document document;
    private Page page;
    private StudentDao studentDao;
    public DocumentPDF(){
        document = new Document();
        page = document.getPages().add();
        studentDao = new StudentDao();
    }

    public void generateReport(){
        //Insertar titulo
        TeXFragment titulo = new TeXFragment("Reporte de calificaciones");
        page.getParagraphs().add(titulo);

        //Insertar calificaciones
        String califText = "";
        ArrayList<Student> students = studentDao.readStudents();
        for(Student student: students){
            califText = "Materia: "+ student.getMateria() + " Matricula: "+  student.getMatricula() + "Calificanión : " + student.getCalificacion();
            TeXFragment calificaciones = new TeXFragment(califText);
            page.getParagraphs().add(calificaciones);
        };

        document.save("HelloWorld_out.pdf");

    }

    public static void main(String[] args) {
        DocumentPDF documentPDF = new DocumentPDF();
        documentPDF.generateReport();
    }
}
