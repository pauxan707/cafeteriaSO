package com.example.Modelo;

import java.util.Random;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que genera pedidos pseudoaleatorios a partir de una semilla. UNA clase por programa (ids compartidas). 
 *
 */
public class GeneradorPedidos {
    private Random randomConSemilla;
    private int idCounter = 1;
    
    private final List<Cliente> clientesBase = new LinkedList<>(List.of( //de estos se van a elegir para ir generando pedidos
        new Cliente("Juan", Rol.ESTUDIANTE),
        new Cliente("Joseph Abbad", Rol.PROFESOR),
        new Cliente("Napoleón", Rol.PROFESOR),
        new Cliente("Marta", Rol.ESTUDIANTE),
        new Cliente("Eliana", Rol.PROFESOR),
        new Cliente("Gervasio", Rol.ESTUDIANTE),
        new Cliente("El abominable", Rol.ESTUDIANTE)
    ));    


    public GeneradorPedidos(int semilla) {
        this.randomConSemilla = new Random(semilla);
    }

    public List<Pedido> generarPedidos(int cantidad, FuentePedido fuente) {
        List<Pedido> pedidosGenerados = new LinkedList<>();

        for (int i = 0; i < cantidad; i++) {
            Cliente clienteRandom = clientesBase.get(Math.abs(randomConSemilla.nextInt() % clientesBase.size())); //convierte el nextInt en  un índice de los posibles (7) en la lista de clientes.
            Producto productoRandom = Producto.values()[Math.abs((randomConSemilla.nextInt() % Producto.values().length))]; //lo mismo pero elige entre los items del enum de producto. usamos abs porque por la forma que java calcula módulo, se obtienen valores negativos que no necesitamos.
            
            Pedido pedido = new Pedido(idCounter, clienteRandom, productoRandom, fuente);
            idCounter++;
            pedidosGenerados.add(pedido);
        }

        return pedidosGenerados;
        
    }


}
