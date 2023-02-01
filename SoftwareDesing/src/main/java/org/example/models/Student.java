package org.example.models;

public class Student {
    private String materia = "Diseño de software";
    private String name;

    private String surname;

    private String secondSurname;

    private Long matricula;

    private int calificacion;

    public Student(String name, String surname, String secondSurname, Long matricula, int calificacion) {
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.matricula = matricula;
        this.calificacion = calificacion;
    }

    public String getMateria() {
        return materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Diseño de software,"+ name + "," + surname +
                "," + secondSurname +
                "," + matricula +
                "," + calificacion;
    }
}
