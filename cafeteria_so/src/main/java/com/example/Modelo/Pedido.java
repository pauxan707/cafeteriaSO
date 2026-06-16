package com.example.Modelo;

public class Pedido {
    int id;
    Cliente cliente;
    String producto;
    public int tiempoPreparacion;
    FuentePedido fuentePedido;

    public Pedido(int id, String producto, int tiempoPreparacion, FuentePedido fuentePedido) {
        this.id = id;
        this.cliente = new Cliente();
        this.producto = producto;
        this.tiempoPreparacion = tiempoPreparacion;
        this.fuentePedido = fuentePedido;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public String getProducto() {
        return producto;
    }

}
