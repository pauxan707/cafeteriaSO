package com.example.Modelo;

public class Cliente {
    Rol rol;
    int puntosFidelidad;
    String nombre;
    int id;

    public Cliente(Rol rol, int puntosFidelidad, String nombre, int id){
        this.rol = rol;
        this.puntosFidelidad = puntosFidelidad;
        this.nombre= nombre;
        this.id = id;
    }

    public Rol getRol(){
        return rol;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntos(){
        return puntosFidelidad;
    }

    public int getId(){
        return id;
    }

    public void agregarPuntos(){
        this.puntosFidelidad++;
    }

    
}
