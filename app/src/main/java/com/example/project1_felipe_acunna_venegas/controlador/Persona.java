package com.example.project1_felipe_acunna_venegas.controlador;

import androidx.annotation.NonNull;

public class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;
    private boolean sexo;
    private String deporte;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", deporte='" + deporte + '\'' +
                '}';
    }

    public int getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getSexo() {
        return sexo;
    }

    public String getRut() {
        return rut;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;

    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
