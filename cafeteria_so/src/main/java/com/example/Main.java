package com.example;

import com.example.Modelo.FuenteDePedidos;
import com.example.Modelo.FuentePedido;
import com.example.Modelo.GeneradorPedidos;
import com.example.Modelo.Scheduler;
import com.example.Recursos.Caja;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Caja caja = new Caja(500); 
        GeneradorPedidos generador = new GeneradorPedidos(67);
        Scheduler scheduler = new Scheduler();

        Thread app = new Thread( //creamos las 3 fuentes, cada una con el scheduler y una lista generada por el generador
            new FuenteDePedidos(
                FuentePedido.APP, 
                scheduler, 
                generador.generarPedidos(50, FuentePedido.APP)
            )
        );

        Thread totem = new Thread(
            new FuenteDePedidos(
                FuentePedido.TOTEM, 
                scheduler, 
                generador.generarPedidos(50, FuentePedido.TOTEM)
            )
        );

        Thread mostrador = new Thread(
            new FuenteDePedidos(
                FuentePedido.MOSTRADOR, 
                scheduler, 
                generador.generarPedidos(50, FuentePedido.MOSTRADOR)
            )
        );


        long inicioSimulacion = System.nanoTime();

        app.start();
        totem.start();
        mostrador.start();



        // hilos baristas 



        app.join();
        totem.join();
        mostrador.join();
        
        scheduler.finalizar();


        long duracionSimulacion = System.nanoTime() - inicioSimulacion;

        
        
        

        

    }
}
