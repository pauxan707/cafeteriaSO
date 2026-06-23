package com.example.Modelo;

public class Cliente {
    Rol rol;
    int puntosFidelidad;
    String nombre;
    int id;
    private static int idCounter = 1;

    public Cliente(String nombre, Rol rol){
        this.rol = rol;
        this.nombre= nombre;
        this.id = idCounter;
        idCounter++;
    
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
