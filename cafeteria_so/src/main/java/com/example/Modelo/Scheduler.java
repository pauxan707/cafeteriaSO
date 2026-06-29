package com.example.Modelo;

import java.util.LinkedList;
import java.util.List;

/**
* Esta clase contiene la cola con prioridad que almacena los pedidos, y se encarga de devolver el siguiente pedido.
*/
public class Scheduler {
    private List<Pedido> colaPedidos = new LinkedList<>();
    private static final double FACTOR_ENVEJECIMIENTO = 0.2; //factor extra que regula el envejecimiento.
    private boolean terminado = false;
    private final boolean envejecimientoActivo;

    public Scheduler(boolean envejecimientoActivo) {
        this.envejecimientoActivo = envejecimientoActivo;
    }

    public synchronized void finalizar() {
        terminado = true;
        notifyAll();
    }

    public synchronized void agregarPedido(Pedido pedido) {
        colaPedidos.add(pedido);
        notify(); //usamos notify en lugar de notifyall porque no importa cuál hilo se desipierta ya que todos son baristas y esperan lo mismo.
    }


    public synchronized Pedido obtenerSiguientePedido() throws InterruptedException {

        while (colaPedidos.isEmpty() && !terminado) {
            wait(); //duerme hasta que llegue un pedido. Esta es una ventaja de monitor (synchronized) sobre un mutex, evita busy waiting del barista que pide pedido.
        }
        if (colaPedidos.isEmpty()) {
            return null;
        }
        
        Pedido pedidoDeMayorPrioridad = null; // guardo el PEDIDO 
        double mejorPrioridad = Double.NEGATIVE_INFINITY;


        for (Pedido pedidoActual : colaPedidos){
            pedidoActual.calcularPrioridad(); // para que cargue el metodo y actualice la prioridad, que es un atributo dentro del pedido
            double prioridadPedidoActual = calcularPrioridadConEnvejecimiento(pedidoActual);

            if (prioridadPedidoActual > mejorPrioridad) { //el desempate se define acá, si tienen valores iguales, gana el que fue añadido antes a la lista enlazada (desempate por FIFO). de todas formas, un empate entre doubles usando nanotime es casi imposible.
                                                            //concretamente, si son iguales devuelve false, lo que tomaría a mejorPrioridad como mayor, y debido a que se recorre de izq a derecha, mejorPrioridad es un valor más antiguo que el siguiente en la lista.
                mejorPrioridad = prioridadPedidoActual;
                pedidoDeMayorPrioridad = pedidoActual;
                
            }

            
        }

        colaPedidos.remove(pedidoDeMayorPrioridad); //es seguro quitar el item acá, ya que está dentro de una sección crítica synchronized. Nadie lo leerá mientras se quita.
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
        if (!envejecimientoActivo) {
            return pedido.prioridad;
        }
        double diferencia = System.nanoTime() - pedido.getTiempoCreacion();
        double diferenciaEnSegundos = diferencia / 1_000_000_000.0;
        double bonusEnvejecimiento = Math.pow(diferenciaEnSegundos, 2) * FACTOR_ENVEJECIMIENTO;
        return pedido.prioridad + bonusEnvejecimiento;
    }
}
