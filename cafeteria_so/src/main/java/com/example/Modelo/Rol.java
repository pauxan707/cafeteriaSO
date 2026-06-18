package com.example.Modelo;

public enum Rol {
    PROFESOR(50),
    ESTUDIANTE(20);

    private final int prioridadBase;

    Rol(int prioridadBase) {
        this.prioridadBase = prioridadBase;
    }

    public int getPrioridadBase() {
        return prioridadBase;
    }
}