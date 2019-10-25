package com.example.tplab3.model;

import androidx.annotation.NonNull;

public class Usuario {
    private long dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;

    public Usuario(long dni, String nombre, String apellido, String mail, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public Usuario() {
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return "Usuario{"+"dni="+dni+
                ", apellido="+apellido+'\''+
                ", nombre="+nombre+'\''+
                ", mail="+mail+'\''+
                ", password="+password+'\''+
        "}";
    }
}

