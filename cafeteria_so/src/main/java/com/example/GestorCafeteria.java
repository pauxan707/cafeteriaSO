package com.example;

import com.example.Modelo.Cliente;
import com.example.Recursos.Cafetera;

public class GestorCafeteria {
    public void registrarCompra(Cliente cliente){
        synchronized(cliente){
            cliente.agregarPuntos();
        }
    }

    public void registrarCliente(Cliente cliente){

    }
    //t espera por pedido y promedio
    // t ptomedio de pedido desde que se pide hasta ue se entrega
    // porcentaje de t de cafetera ocupada
    // 

    public double calcularPorcentajeCafetera(Cafetera cafetera, long duracionSimulacion) {
    return (cafetera.getTiempoOcupada() * 100.0) / duracionSimulacion;
}
}
