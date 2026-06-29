package com.example;

import com.example.Modelo.FuenteDePedidos;
import com.example.Modelo.FuentePedido;
import com.example.Modelo.GeneradorPedidos;
import com.example.Modelo.Scheduler;
import com.example.Recursos.Barista;
import com.example.Recursos.Cafetera;
import com.example.Recursos.Caja;


public class Main {
    public static void main(String args[]) throws InterruptedException {
        //inicializamos recursos compartidos
        Caja caja = new Caja(500); 
        Cafetera cafetera = new Cafetera();
        GestorCafeteria gestor = new GestorCafeteria();
        GeneradorPedidos generador = new GeneradorPedidos(67);
        Scheduler scheduler = new Scheduler();

        //fuentes de pedidos
        Thread app = new Thread( //creamos las 3 fuentes, cada una con el scheduler y una lista generada por el generador
            new FuenteDePedidos(
                FuentePedido.APP, 
                scheduler, 
                generador.generarPedidos(10, FuentePedido.APP)
            )
        );

        Thread totem = new Thread(
            new FuenteDePedidos(
                FuentePedido.TOTEM, 
                scheduler, 
                generador.generarPedidos(10, FuentePedido.TOTEM)
            )
        );

        Thread mostrador = new Thread(
            new FuenteDePedidos(
                FuentePedido.MOSTRADOR, 
                scheduler, 
                generador.generarPedidos(10, FuentePedido.MOSTRADOR)
            )
        );

        //baristas
        int N_BARISTAS = 3; //hacemos este bloque para poder variar la cantidad de baristas fácilmente
        Thread[] baristas = new Thread[N_BARISTAS];
        for (int i = 0; i < N_BARISTAS; i++) {
            baristas[i] = new Thread(new Barista(i + 1, cafetera, scheduler, caja, gestor));
        }

        //empieza oficialmente simulacion
        long inicioSimulacion = System.nanoTime();

        app.start();
        totem.start();
        mostrador.start();
        for (Thread b : baristas) b.start();

        // (suceden cosas entre hilos, etc)


        //esperamos a que dichas cosas terminen (que se envíen todos los pedidos al scheduler)
        app.join();
        totem.join();
        mostrador.join();
        
        scheduler.finalizar(); //despierta a los baristas que estarán en wait()

        for (Thread b : baristas) b.join(); //esperamos que cada barista termine


        long duracionSimulacion = System.nanoTime() - inicioSimulacion;


        //========= MÉTRICAS ===============

        System.out.println("=== MÉTRICAS ===");
        System.out.printf("Pedidos atendidos:       %d%n", gestor.getPedidosAtendidos().size());
        System.out.printf("Espera promedio:         %.2f ms%n", gestor.tiempoPromedioEspera());
        System.out.printf("Tiempo promedio total:   %.2f ms%n", gestor.tiempoPromedioTotal());
        System.out.printf("Utilización cafetera:    %.2f%%%n", gestor.calcularPorcentajeCafetera(cafetera, duracionSimulacion));
        System.out.printf("Pedidos con espera >5s:  %d%n", gestor.pedidosQueExcedieronEspera(5000));

        
        
        

        

    }
}
