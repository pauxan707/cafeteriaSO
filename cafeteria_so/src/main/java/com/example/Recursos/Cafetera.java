package com.example.Recursos;

import java.util.concurrent.locks.ReentrantLock;

import com.example.Modelo.Pedido;

public class Cafetera {
     private ReentrantLock mutex;

    public Cafetera() {
        this.mutex = new ReentrantLock();
    }
    public void prepararCafe(Pedido pedido) {
        mutex.lock();
        try {
            Thread.sleep(pedido.getTiempoPreparacion());
            System.out.println("Preparado para el pedido: " + pedido.getProducto());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.unlock();
        }
    }
}
