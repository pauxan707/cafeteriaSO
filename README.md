[Obligatorio_Pt2. Antonella Amaro_Federico Baptista_Marco Carlomagno (1).pdf](https://github.com/user-attachments/files/33271058/Obligatorio_Pt2.Antonella.Amaro_Federico.Baptista_Marco.Carlomagno.1.pdf)

Repo para el código del segundo obligatorio de Sistemas Operativos, primer semestre de segundo año.

Antonella Amaro, Federico Baptista, Marco Carlomagno.

La problemática planteada va sobre controlar los pocos recursos compartidos que hay para
los muchos pedidos concurrentes que se generan, intentando evitar la inanición.
Hay múltiples entradas que producen pedidos a su propio ritmo, no todos con la misma
prioridad, por lo que hay que gestionar cuál se procesa primero sin dejar indefinidamente
esperando al más antiguo o al que tiene menos prioridad.

Solución propuesta:
Para resolver la problemática de gestionar la cantina, proponemos un sistema con
generación de pedidos (fuente de pedidos), recursos compartidos como la cafetera o la
caja, un scheduler que maneja los pedidos y un gestor general del sistema.
Se modelaron los pedidos como objetos que pasan por el flujo de trabajo (crear pedido,
hacerlo, pagarlo), los baristas se modelaron como hilos que toman algún pedido.
Los recursos compartidos como la cafetera y la caja se protegen con mecanismos de
sincronización, utilizando mutex para controlar el acceso a los mismos, evitando así
condiciones de carrera. A su vez, implementamos un planificador que mantiene una cola de
pedidos que se recalcula en cada ciclo, este gestiona el orden de los pedidos aplicando una
fórmula de prioridad.

