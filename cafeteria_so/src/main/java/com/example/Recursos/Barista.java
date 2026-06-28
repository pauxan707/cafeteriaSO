package com.example.Recursos;

import java.util.concurrent.Semaphore;

import com.example.Modelo.Pedido;
import com.example.Modelo.Producto;
import com.example.Modelo.Scheduler;

public class Barista implements Runnable{
    //creo N instancias en main de hilos de baristas
    private int id;
    private Cafetera cafetera;
    private Scheduler scheduler;

    public Barista(int id, Cafetera cafetera, Scheduler scheduler) {
        this.id = id;
        this.cafetera = cafetera;
        this.scheduler = scheduler; 
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Pedido pedido = scheduler.obtenerSiguientePedido();
                if (pedido == null) break; //este null lo reciben cuando colaPedidos es empty, ya que scheduler devuelve null en ese caso
                prepararPedido(pedido, cafetera);
            }

            catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            }
        }
    }
    

    public void prepararPedido(Pedido pedido, Cafetera cafetera) {
        if (pedido.getProducto() == Producto.CAFE) { 
            cafetera.prepararCafe(pedido);
        } else {
            prepararOtraCosa(pedido);
        } 
    }

    private void prepararOtraCosa(Pedido pedido) {
        try {
            System.out.println("Preparando pedido: " + pedido.getProducto() + id + "lo esta preparando");
            Thread.sleep(pedido.getTiempoPreparacion());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //aca llamo a la caja?!
        }
    }


    /* 
    private Semaphore baristasDisponibles;

    public Baristas(int cantidad){
        this.baristasDisponibles = new Semaphore(cantidad);
    }
        
    //contructor con hilo por barista y c/u sea un mutex o asi esta bien
    public void prepararPedido(Pedido pedido, Cafetera cafetera) {
       baristasDisponibles.acquire();
        try{
            if (pedido.getProducto() == Producto.CAFE) { 
            cafetera.prepararCafe(pedido);
        } else {
            prepararOtraCosa(pedido);
        } }
        finally{
        baristasDisponibles.release();
    }
    }

    private void prepararOtraCosa(Pedido pedido) {
        try {
            Thread.sleep(pedido.getTiempoPreparacion());
            System.out.println("Preparando pedido: " + pedido.getProducto());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }*/
}

