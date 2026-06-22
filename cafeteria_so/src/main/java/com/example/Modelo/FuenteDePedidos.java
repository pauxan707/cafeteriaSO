package com.example.Modelo;
import java.util.LinkedList;
import java.util.List;

public class FuenteDePedidos implements Runnable{
    public FuentePedido via;
    private List<Pedido> listaPedidos = new LinkedList<>();

    public FuenteDePedidos(FuentePedido via){
        this.via = via;
    }
    @Override
    public void run()
    {
     
     // que hago aca?  hasta ahi llegue
    }
public void generarPedido(int id, Cliente cliente, Producto producto, int tiempoPreparacion, FuentePedido fuentePedido)
{
    Pedido nuevo = new Pedido(id, cliente, producto,tiempoPreparacion,this.via);
    listaPedidos.add(nuevo);
}

}
