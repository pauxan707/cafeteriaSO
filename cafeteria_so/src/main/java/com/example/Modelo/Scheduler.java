package com.example.Modelo;

import java.util.LinkedList;
import java.util.List;

/**
* Esta clase contiene la cola con prioridad que almacena los pedidos, y se encarga de devolver el siguiente pedido.
*/
public class Scheduler {
private List<Pedido> colaPedidos = new LinkedList<>();

public void ordenarCola(){
int i = 0;
Pedido mejorPrioridad = null;  //guardo el PEDIDO.
while (i < colaPedidos.size())
{

    Pedido pedidoActual= colaPedidos.get(i);
    pedidoActual.calcularPrioridad(); //para que cargue el metodo

    if (mejorPrioridad == null)
{
    mejorPrioridad = pedidoActual;
}

if (pedidoActual.prioridad < mejorPrioridad.prioridad)
{
    pedidoActual.prioridad= pedidoActual.prioridad; //ENVEJECE
}  //  PONER ACA LA FORMULA !!!!!!!!!!!11!!!!!!!!!!!1!!

if (pedidoActual.prioridad > mejorPrioridad.prioridad)
{
    mejorPrioridad= pedidoActual; //cambio el mejor pedido por el actual
}
 i= +1;

} 

}
}
