package com.example.Modelo;

public enum Producto {
    CAFE(30),
    SANGUCHE(60),
    AGUA(10),
    BROWNIE(15),
    MILANESA(100),
    ALFAJOR(20),
    TALLARINES_CON_TUCO(555); //uno que dure bastante


    private final int tiempoBase;

    Producto(int tiempoBase) {
        this.tiempoBase = tiempoBase;
    }

    public int getTiempoBase() {
        return tiempoBase;
    }
}
