package com.example.Modelo;
import java.util.LinkedList;
import java.util.List;

public class FuenteDePedidos implements Runnable{
    public FuentePedido via;
    private List<Pedido> listaPedidos;
    private Scheduler scheduler;

    public FuenteDePedidos(FuentePedido via, List<Pedido> pedidos, Scheduler scheduler){
        this.via = via;
        this.listaPedidos = pedidos;
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
    
        for (Pedido pedido : listaPedidos) {
            pedido.


        }

        


    }
     
}
   


