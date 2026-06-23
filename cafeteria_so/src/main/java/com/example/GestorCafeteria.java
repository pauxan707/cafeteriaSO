package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Modelo.Cliente;
import com.example.Modelo.Pedido;
import com.example.Modelo.Scheduler;
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

    public double calcularPorcentajeCafetera(Cafetera cafetera, long duracionSimulacion) {
    return (cafetera.getTiempoOcupada() * 100.0) / duracionSimulacion;
}

    public List<Pedido> getPedidosAtendidos(){
        return pedidosAtendidos;
    }

    public long tiempoEsperaPedido(){
        for (Pedido p : pedidosAtendidos){
           long espera = p.getTiempoCreacion;
    }
        return espera;
    }

    //falta espera de tdos
    //espera prom suma de las esperas/ pedidos atenditos.tamano
    //rtengo un pedo entendiendo la eltra asi q no den bola a esto
    // promedio de espera de tiemooCreacion desde    netra a q sale

    public int pedidosEspera(){
    int UMBRAL = 10;
    int excedidos = 0;
    for (Pedido p : pedidosAtendidos) {
        double espera = p.getTiempoInicio() - p.getTiempoLlegada();
        if (espera > UMBRAL) excedidos++;
    }

