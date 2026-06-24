package com.example.Recursos;

import java.util.concurrent.locks.ReentrantLock;

import com.example.Modelo.Pedido;

public class Caja {
    private ReentrantLock mutex;
    private int tiempoCobro;

    public Caja(int tiempoCobro) {
        this.mutex = new ReentrantLock();
        this.tiempoCobro= tiempoCobro;
    }

    public void cobrar(Pedido pedido){
        mutex.lock();
        try {
            Thread.sleep(tiempoCobro);
            System.out.println("Cobrando el pedido " + pedido.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.unlock();
        }
    }

}
