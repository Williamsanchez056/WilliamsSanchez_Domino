# Juego de Domino Criollo 

Proyecto desarrollado para la asignatura de Programación, enfocado en la implementación del patrón de diseño **MVC (Modelo-Vista-Controlador)** y el uso de **FXML** para una interfaz moderna y funcional.

##  Funcionalidades
- **Tablero Dinámico:** Visualización de fichas colocadas en tiempo real.
- **Reparto:** Entrega aleatoria de 7 fichas al inicio de la partida.
- **Validación de Jugadas:** Sistema que verifica si una ficha es jugable en los extremos del tablero.
- **Jugadores:** Modo de juego Humano vs Computadora.
- **Sistema de Robo:** Lógica de "pozo" cuando no hay movimientos validos.
- **Conteo de Puntos:** Cálculo automático de puntuación al finalizar la ronda o al trancarse el juego.
- **Interfaz:** Diseño basado en texturas orgánicas y controles intuitivos.

## Tecnologías Utilizadas
- **Lenguaje:** Java 24.0.1
- **Interfaz Gráfica:** JavaFX con FXML 
- **IDE:** Visual Studio Code / Scene Builder
- **Control de Versiones:** Git & GitHub

## Estructura del Proyecto 
- `src/model`: (Ficha, Mazo, Jugador, Tablero).
- `src/view`: Archivos FXML 
- `src/controller`: Manejo de eventos y conexión Vista-Modelo.

## Interfaz y Lógica de Inicio
- **Pantalla de Bienvenida:** Diseño e implementación de `MenuInicio.fxml` con estilo visual de mesa de juego.
- **Controlador de Navegación:** `MenuInicioController.java` para gestionar el cambio fluido entre el menu y el tablero principal.
- **Generación del Mazo:** Lógica para fabricar las 28 fichas reglamentarias (0-0 al 6-6) sin duplicados.
- **Sistema de Barajado:** `Collections.shuffle` para garantizar aleatoriedad en cada partida.
- **Reparto Inicial:** `repartir(7)` que entrega las fichas iniciales al jugador Williams y a la CPU.

## Como Funciona
1. Clona el repositorio: `git clone https://github.com/Williamsanchez056/Domino.git`
2. Asegúrate de tener configurado el SDK de JavaFX en tu IDE
3. Configura los modulos de `javafx.controls`, `javafx.fxml` y `javafx.media`.
4. Ejecuta `Main.java` y suena la musica

## Autor
- **Williams Sánchez** - [Williamsanchez056](https://github.com/Williamsanchez056)