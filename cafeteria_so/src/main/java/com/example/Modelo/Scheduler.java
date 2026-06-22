package com.example.Modelo;

import java.util.LinkedList;
import java.util.List;

public class Scheduler {
private List<Pedido> colaPedidos = new LinkedList<>();

public void ordenarCola(){
int i = 0;
Pedido mejorPrioridad = null;  //guardo el PEDIDO.
while (i < colaPedidos.size())
{

    Pedido pedidoActual= colaPedidos.get(i);

    if (mejorPrioridad == null)
{
    mejorPrioridad = pedidoActual;
}

if (pedidoActual.prioridad > mejorPrioridad.prioridad)
{
    mejorPrioridad= pedidoActual;
}

} 
//todavia no calculo envejecimiento. Pero DEBE
// Hacerse en este mismo metodo (o llamar a otro metodo desde aca)
}
}
