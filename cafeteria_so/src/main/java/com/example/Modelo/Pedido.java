package com.example.Modelo;

/**
 * Clase que modela cada pedido que ingresa al sistema.
 * Cada pedido tiene UN SOLO producto.
 * Se encarga de calcular su prioridad base, sin envejecimiento.
 */
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

    /**
     * 
     * @param id
     * @param cliente
     * @param producto
     * @param tiempoPreparacion
     * @param fuentePedido
     */
    public Pedido(int id, Cliente cliente, Producto producto, FuentePedido fuentePedido) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.tiempoPreparacion = producto.getTiempoBase();
        this.fuentePedido = fuentePedido;
    }

    public void setFuentePedido(FuentePedido fuente) { //agregamos estos métodos para qutiarlos del constructor, ya que primero creamos en el generador, SIN estos dos campos
        this.fuentePedido = fuente;
    }

    public void marcarIngreso() { //idem ^^^^
        this.tiempoCreacion = System.nanoTime();
    }

    public long getTiempoCreacion() {
        return tiempoCreacion;
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
