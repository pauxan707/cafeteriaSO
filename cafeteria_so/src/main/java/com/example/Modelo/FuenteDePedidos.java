package com.example.Modelo;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa una fuente de pedidos (totem, etc)
 * <p>
 * Cada objeto es un hilo que va lanzando hacia el scheduler sus pedidos, cada cierto tiempo.
 * <p>
 * Los pedidos (inputs) son cargados a la lista usando un generador pseudoaleatorio.
 * 
 */
public class FuenteDePedidos implements Runnable{
    public FuentePedido via;
    private List<Pedido> listaPedidos = new LinkedList<>();

    public FuenteDePedidos(FuentePedido via){
        this.via = via;
    }

    @Override
    public void run()
    {
    
     

     //marcaringreso
     //agregar scheduler
    }
    public void generarPedido(int id, Cliente cliente, Producto producto, int tiempoPreparacion, FuentePedido fuentePedido)
    {
        Pedido nuevo = new Pedido(id, cliente, producto,tiempoPreparacion,this.via);
        listaPedidos.add(nuevo);
    }

}
