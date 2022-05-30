package com.example.clase18_11_21;

public class Coneccion {

    String carrera;
    String materia;
    String id;
    String facultad;

    public String getId() {
        return id;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getMateria() {
        return materia;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }


    public Coneccion(String id, String facultad, String carrera, String materia) {
        this.id = id;
        this.facultad = facultad;
        this.carrera = carrera;
        this.materia = materia;
    }



}
