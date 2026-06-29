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
    private long tiempoCreacion; //momento en el que la fuente pide agregar al scheduler (NO el momento exacto en el que se entra; puede quedar esperando que se libere monitor)
    private long tiempoInicio; //momento en que lo agarra un barista
    private long tiempoEntrega; // momento en el que se entrega

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

    public Cliente getCliente() { return cliente; }

    public void marcarIngreso() { //no se define en el constructor, se define cuando lo agarra el hilo de fuente, NO al ser creado por el generador.
        this.tiempoCreacion = System.nanoTime();
    }

    public void marcarInicio() {
        this.tiempoInicio = System.nanoTime();
    }

    public void marcarEntrega() {
        this.tiempoEntrega = System.nanoTime();
    }

    public long getTiempoInicio()   { return tiempoInicio; }
    public long getTiempoEntrega()  { return tiempoEntrega; }
    public long getTiempoLlegada()  { return tiempoCreacion; }

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
