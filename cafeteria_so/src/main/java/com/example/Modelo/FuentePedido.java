package com.example.Modelo;

public enum FuentePedido {
    APP(15),
    TOTEM(20),
    MOSTRADOR(40); //mayor número es menor frecuencia, mayor demora entre generaciones.

    private final int frecuenciaDeGeneración;

    FuentePedido(int frecuenciaDeGeneración){
        this.frecuenciaDeGeneración = frecuenciaDeGeneración;
    }

    public int getFrecuencia() {
        return frecuenciaDeGeneración;
    }

}


