package com.example.Modelo;

import java.util.Random;
import java.util.List;

/**
 * Clase que genera pedidos pseudoaleatorios a partir de una semilla. 
 */
public class GeneradorPedidos {
    private Random randomConSemilla;
    private final List<Producto> productosBase = new LinkedList<>( //de acá se van a elegir para crear los pedidos al "azar"

    );


    public GeneradorPedidos(int semilla) {
        this.randomConSemilla = new Random(semilla);
    }

    public List<Pedido> generarPedidos(int cantidad) {
        

        return null;
    }
}
