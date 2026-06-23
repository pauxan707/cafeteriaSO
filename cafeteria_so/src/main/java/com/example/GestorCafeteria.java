package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Modelo.Cliente;
import com.example.Recursos.Cafetera;

public class GestorCafeteria {
    private List<Cliente> listaClientes = new ArrayList<>();

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
    // porcentaje de t de cafetera ocupada
    // 

    public double calcularPorcentajeCafetera(Cafetera cafetera, long duracionSimulacion) {
    return (cafetera.getTiempoOcupada() * 100.0) / duracionSimulacion;
}
}
