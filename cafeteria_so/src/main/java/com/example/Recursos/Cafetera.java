package com.example.Recursos;

import java.util.concurrent.locks.ReentrantLock;

import com.example.Modelo.Pedido;

public class Cafetera {
    private ReentrantLock mutex;
    private long tiempoOcupada;

    public Cafetera() {
        this.mutex = new ReentrantLock();
        this.tiempoOcupada = 0;
    }
    public void prepararCafe(Pedido pedido) {
        mutex.lock();
        try {
            long inicio = System.currentTimeMillis();
            Thread.sleep(pedido.getTiempoPreparacion());
            tiempoOcupada += System.currentTimeMillis() - inicio;
            System.out.println("Preparado para el pedido: " + pedido.getProducto());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.unlock();
        }

    }

    public long getTiempoOcupada(){
        return tiempoOcupada;}
}
