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

    public Pedido(int id, Cliente cliente, Producto producto, int tiempoPreparacion, FuentePedido fuentePedido) {
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

    /**
     * Calcula prioridad SIN envejecimiento (se añade en Scheduler, para respetar EXPERT)
     * En función de café, fidelidad y rol del cliente.
     */
    public void calcularPrioridad() {  //debe estar aca por EXPERT.
        int prioridadCafe = (producto == Producto.CAFE) ? 15 : 0; //15 de prioridad extra si el producto es café
        
        prioridad = this.cliente.getPuntos() + this.cliente.rol.getPrioridadBase() + prioridadCafe; 
        
    }
}
