package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Modelo.Cliente;
import com.example.Modelo.Pedido;
import com.example.Recursos.Cafetera;

public class GestorCafeteria {
    private List<Cliente> listaClientes = new ArrayList<>();
    public List<Pedido> pedidosAtendidos = new ArrayList<>();

    public GestorCafeteria(){
        this.pedidosAtendidos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    public void registrarCompra(Cliente cliente){
        synchronized(cliente){
            cliente.agregarPuntos();
        }
    }

    public void registrarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    //t espera por pedido y promedio
    // t ptomedio de pedido desde que se pide hasta ue se entrega



    public void registrarPedidoAtendido(Pedido pedido) {
        synchronized (pedidosAtendidos) { //obtiene el monitor de pedidosAtendidos, funciona esencialmente como un mutex
            pedidosAtendidos.add(pedido);
        }
    }

    public List<Pedido> getPedidosAtendidos(){
        return pedidosAtendidos;
    }



    // ====================métodos de análisis===========
    
    //tiempo promedio hasta que lo agarra un barista
    public double tiempoPromedioEspera() {
        if (pedidosAtendidos.isEmpty()) {
            return 0;
        }

        long suma = 0;

        for (Pedido p : pedidosAtendidos) {
            suma += p.getTiempoInicio() - p.getTiempoLlegada();
        }

        return (suma / (double) pedidosAtendidos.size()) / 1_000_000.0;
    }

    //tiempo promedio total desde llegada hasta entrega
    public double tiempoPromedioTotal() {
        if (pedidosAtendidos.isEmpty()) {
            return 0;
        }

        long suma = 0;

        for (Pedido p : pedidosAtendidos) {
            suma += p.getTiempoEntrega() - p.getTiempoLlegada();
        }

        return (suma / (double) pedidosAtendidos.size()) / 1_000_000.0;
    }


    public double calcularPorcentajeCafetera(Cafetera cafetera, long duracionSimulacion) {
        return (cafetera.getTiempoOcupada() * 100.0) / duracionSimulacion;
    }


    //cuantos pedidos superaron el umbral de espera (en ms, para que sea más legible )
    public int pedidosQueExcedieronEspera(long umbralMs) {
        int excedidos = 0;
        for (Pedido p : pedidosAtendidos) {
            long esperaMs = (p.getTiempoInicio() - p.getTiempoLlegada()) / 1_000_000;
            if (esperaMs > umbralMs) {
                excedidos++;
            } 
        }
        return excedidos;
    }

}