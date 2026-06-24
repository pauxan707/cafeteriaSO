package com.example.Modelo;

public enum FuentePedido { //para los tiempos asumimos que se está generando constantemente, y que cada pedido dura el valor dado.
    APP(15), //en este caso, se lee como "un pedido en la app dura 15 segundos en hacerse, y luego se genera el siguiente"
    TOTEM(20), 
    MOSTRADOR(40); //mayor número es mayor duración del pedido, mayor demora entre generaciones.

    private final int duraciónDeGeneración;

    FuentePedido(int duraciónDeGeneración){
        this.duraciónDeGeneración = duraciónDeGeneración;
    }

    public int getduración() {
        return duraciónDeGeneración;
    }

}


