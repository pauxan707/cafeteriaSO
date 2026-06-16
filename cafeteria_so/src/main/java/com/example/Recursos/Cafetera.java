package com.example.Recursos;

import java.util.concurrent.locks.ReentrantLock;

import com.example.Modelo.Pedido;

public class Cafetera {
    ReentrantLock mutex = new ReentrantLock();

    public void prepararCafe(Pedido pedido) {
        mutex.lock();
        long espera // hay que hacr lo del tiempo
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
