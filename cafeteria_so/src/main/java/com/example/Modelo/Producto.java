package com.example.Modelo;

public enum Producto {
    CAFE(2000),
    SANGUCHE(1500),
    AGUA(400),
    BROWNIE(700),
    MILANESA(2500),
    ALFAJOR(900),
    TALLARINES_CON_TUCO(5000); //uno que dure bastante


    private final int tiempoBase;

    Producto(int tiempoBase) {
        this.tiempoBase = tiempoBase;
    }

    public int getTiempoBase() {
        return tiempoBase;
    }
}
