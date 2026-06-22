package com.example.Modelo;

import java.util.LinkedList;
import java.util.List;

/**
* Esta clase contiene la cola con prioridad que almacena los pedidos, y se encarga de devolver el siguiente pedido.
*/
public class Scheduler { //TODO: implementar un lock para productores-consumidores, tomando fuentes y calculos como secicones criticas
    private List<Pedido> colaPedidos = new LinkedList<>();
    private static final double FACTOR_ENVEJECIMIENTO = 0.2; //factor extra que regula el envejecimiento.

    public Pedido obtenerSiguientePedido() {
        
        Pedido pedidoDeMayorPrioridad = null; // guardo el PEDIDO 
        double mejorPrioridad = Double.NEGATIVE_INFINITY;


        for (Pedido pedidoActual : colaPedidos){
            pedidoActual.calcularPrioridad(); // para que cargue el metodo y actualice la prioridad, que es un atributo dentro del pedido
            double prioridadPedidoActual = calcularPrioridadConEnvejecimiento(pedidoActual);

            if (prioridadPedidoActual > mejorPrioridad) {
                mejorPrioridad = prioridadPedidoActual;
                pedidoDeMayorPrioridad = pedidoActual;
                
            }
        }

        return pedidoDeMayorPrioridad;
    }



    /**
     * Método helper para calcular la prioridad final de cada pedido sumándole el envejecimiento.
     * La utiliza obtenerSiguientePedido() para comparar prioridades finales y saber cual devolver
     * Utiliza una curva cuadrática de x**2
     * 
     * Precondición: asume que ya fue recalculada la prioridad, ya que accede directamente al atributo.
     * Sucede este recalculo en la primera línea del foreach de obtenerSiguientePedido().
     * @param pedido
     * 
     */
    private double calcularPrioridadConEnvejecimiento(Pedido pedido){
        double diferencia = System.nanoTime() - pedido.getTiempoCreacion();
        double diferenciaEnSegundos = diferencia / 1_000_000_000.0;
        double bonusEnvejecimiento = Math.pow(diferenciaEnSegundos, 2) * FACTOR_ENVEJECIMIENTO;
        return pedido.prioridad + bonusEnvejecimiento;
    }
}
