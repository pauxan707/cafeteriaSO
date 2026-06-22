package com.example.Modelo;

public class Pedido {
    int id;
    Cliente cliente;
    Producto producto;
    public int tiempoPreparacion;
    FuentePedido fuentePedido;
    private long tiempoCreacion;
    private long tiempoInicio;
    private long tiempoEntrega; // estos son para los calculos
    double prioridad;

    public Pedido(int id, Producto producto, int tiempoPreparacion, FuentePedido fuentePedido) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.tiempoPreparacion = tiempoPreparacion;
        this.fuentePedido = fuentePedido;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getId(){
        return id;
    }
    public void calcularPrioridad()  //debe estar aca por EXPERT.
  {
    int prioridadCafe= 0;
if (producto == producto.CAFE)
{
    prioridadCafe = 1;
}
    prioridad= this.cliente.getPuntos() + this.cliente.rol.getPrioridadBase()+ prioridadCafe;
  }
}
