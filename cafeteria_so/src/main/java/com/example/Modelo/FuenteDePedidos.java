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
    private Scheduler scheduler;

    public FuenteDePedidos(FuentePedido via, Scheduler scheduler, List<Pedido> listaPedidos){
        this.via = via;
        this.scheduler = scheduler;
        this.listaPedidos = listaPedidos;
    }

    @Override
    public void run() {
        for (Pedido pedido : listaPedidos) {
            try {
            Thread.sleep(via.getduración() * 100); // tomamos una escala de simulación de 1:10, entonces multiplicamos la duración por 100 (1000 de milisegundos, dividido 10 para la escala).
            pedido.marcarIngreso();
            scheduler.agregarPedido(pedido);
            }

            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return; //como fue interrumpido (al acabar el programa), debemos hacer que se finalice, se acaba el run()
            }
        }
    }
    

}
