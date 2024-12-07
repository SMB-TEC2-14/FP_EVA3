
package fp_final.proyect_the_drunk.pkg3ngineerz_casino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FP_FINALPROYECT_The_Drunk3ngineerz_Casino {
    
    public static double saldo = 1000.0;

    public static void main(String[] args) {
        //CODE
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Mensaje de bienvenida
        System.out.println("Hola Jugador, bienvenido al CASINO VIRTUAL");
        System.out.println("Tenemos 5 juegos a elegir para ti que son los siguientes:");
        System.out.println("Tu saldo inicial es de: $" + saldo);

        while (continuar) {
            // Mostrar el menú
            mostrarMenu();

            // Leer la opción del usuario
            System.out.print("Cual deseas elegir? ");
            int opcion = scanner.nextInt();

            // Ejecutar la acción correspondiente
            continuar = ejecutarOpcion(opcion, scanner);
        }

        scanner.close();
        System.out.println("Programa terminado. Hasta luego! :D");
    }

    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("OPCION 1: BLACKJACK");
        System.out.println("OPCION 2: DADOS");
        System.out.println("OPCION 3: RULETA");
        System.out.println("OPCION 4: TRAGAMONEDAS");
        System.out.println("OPCION 5: CARRERA DE CABALLOS");
        System.out.println("OPCION 0: SALIR");
    }

    // Método para ejecutar la acción según la opción
    private static boolean ejecutarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                System.out.println("Has elegido Blackjack");
                System.out.println("\nLas Reglas del Juego son las Siguientes:");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("El valor de las cartas es:");
                System.out.println("Los numeros valen su numero, J Q K tienen un valor de 10, y la A vale 1 o 11");
                System.out.println("El objetivo es que el jugador saque un numero cercano a 21 o 21, pero no pasarse de 21");
                System.out.println("Una vez explicado lo anterior, empecemos! :D");
                System.out.println("--------------------------------------------------------------------------\n");
                juegoBlackjack(scanner);
                break;

            case 2:
                System.out.println("Has elegido Dados");
                juegoDados(scanner);
                break;

            case 3:
                System.out.println("Has elegido Ruleta");
                juegoRuleta(scanner);
                break;

            case 4:
                System.out.println("Has elegido Tragamonedas");
                System.out.println("\nEl juego consiste en que pruebes suerte y te salgan 3 figuras iguales");
                System.out.println("Las figuras son: Corazon, Diamante, Herradura, Campana y Limon\n");
                juegoTragamonedas(scanner);
                break;

            case 5:
                System.out.println("Has elegido Carrera de Caballos");
                juegoCaballos(scanner);
                break;

            case 0:
                System.out.println("Saliendo del programa...");
                return false;

            default:
                System.out.println("Opcion invalida. Por favor, elige una opcion entre 0 y 5.");
        }
        return true;
    }

    // Método para el juego de Blackjack
    public static void juegoBlackjack(Scanner scanner) {
        String opcion = null;

        do {
            System.out.println("Tu saldo actual es: $" + saldo);
            System.out.print("Cuanto dinero deseas apostar? (en dolares): ");
            double apuesta = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            if (apuesta > saldo || apuesta <= 0) {
                System.out.println("Apuesta invalida. Debes apostar una cantidad positiva y no mayor a tu saldo.");
                continue;
            }

            double ganancia = jugarBlackjack(apuesta, scanner);

            saldo += ganancia - apuesta; // Actualizar saldo

            System.out.println("Tu saldo actual es: $" + saldo);

            if (saldo <= 0) {
                System.out.println("Te has quedado sin saldo. El juego ha terminado.");
                break;
            }

            System.out.print("Deseas jugar otra vez? (s/n): ");
            opcion = scanner.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));

        System.out.println("Gracias por jugar Blackjack. Hasta luego!");
    }

    public static double jugarBlackjack(double apuesta, Scanner scanner) {
        String[] mazo = crearMazo();
        mezclarMazo(mazo);

        String[] manoJugador = new String[12];
        String[] manoBanca = new String[12];
        int indiceJugador = 0, indiceBanca = 0;

        // Repartir dos cartas iniciales
        manoJugador[indiceJugador++] = mazo[indiceJugador + indiceBanca];
        manoJugador[indiceJugador++] = mazo[indiceJugador + indiceBanca];
        manoBanca[indiceBanca++] = mazo[indiceJugador + indiceBanca];
        manoBanca[indiceBanca++] = mazo[indiceJugador + indiceBanca];

        // Turno del jugador
        boolean jugadorTerminado = false;
        while (!jugadorTerminado) {
            System.out.print("Tu mano: ");
            mostrarMano(manoJugador, indiceJugador);
            int puntosJugador = calcularPuntos(manoJugador, indiceJugador);
            System.out.println("Puntos: " + puntosJugador);

            if (puntosJugador > 21) {
                System.out.println("Te pasaste de 21! Pierdes.");
                return 0; // Pierde la apuesta
            }

            System.out.print("Quieres otra carta? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                manoJugador[indiceJugador++] = mazo[indiceJugador + indiceBanca];
            } else {
                jugadorTerminado = true;
            }
        }

        // Turno de la banca
        while (calcularPuntos(manoBanca, indiceBanca) < 17) {
            manoBanca[indiceBanca++] = mazo[indiceJugador + indiceBanca];
        }

        // Mostrar resultados
        System.out.print("Mano de la banca: ");
        mostrarMano(manoBanca, indiceBanca);
        int puntosBanca = calcularPuntos(manoBanca, indiceBanca);
        System.out.println("Puntos de la banca: " + puntosBanca);

        int puntosJugador = calcularPuntos(manoJugador, indiceJugador);

        if (puntosBanca > 21 || puntosJugador > puntosBanca) {
            System.out.println("Ganaste!");
            return apuesta * 2; // Gana el doble de lo apostado
        } else if (puntosJugador < puntosBanca) {
            System.out.println("La banca gana.");
            return 0; // Pierde la apuesta
        } else {
            System.out.println("Empate. Recuperas tu apuesta.");
            return apuesta; // Recupera su apuesta
        }
    }

    public static String[] crearMazo() {
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] mazo = new String[52];
        int indice = 0;

        for (String palo : palos) {
            for (String valor : valores) {
                mazo[indice++] = valor + " de " + palo;
            }
        }
        return mazo;
    }

    public static void mezclarMazo(String[] mazo) {
        Random random = new Random();
        for (int i = 0; i < mazo.length; i++) {
            int j = random.nextInt(mazo.length);
            String temp = mazo[i];
            mazo[i] = mazo[j];
            mazo[j] = temp;
        }
    }

    public static int calcularPuntos(String[] mano, int cantidadCartas) {
        int puntos = 0, ases = 0;

        for (int i = 0; i < cantidadCartas; i++) {
            String valor = mano[i].split(" ")[0];

            if (valor.equals("A")) {
                puntos += 11;
                ases++;
            } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) {
                puntos += 10;
            } else {
                puntos += Integer.parseInt(valor);
            }
        }

        // Ajustar ases si es necesario
        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    public static void mostrarMano(String[] mano, int cantidadCartas) {
        for (int i = 0; i < cantidadCartas; i++) {
            System.out.print(mano[i] + " ");
        }
        System.out.println();
    }

    // Método para el juego de Dados
    public static void juegoDados(Scanner scanner) {
        Random random = new Random();
        System.out.println("Bienvenido a Craps!");
        System.out.println("Tiro de salida (Come Out Roll):\n" +
                "\n" +
                "Lanzas dos dados.\n" +
                "Ganas si sacas 7 u 11.\n" +
                "Pierdes si sacas 2, 3 o 12 (esto se llama \"craps\").\n" +
                "Cualquier otro numero (4, 5, 6, 8, 9, 10) se convierte en tu \"punto\".\n" +
                "Ronda de punto:\n" +
                "\n" +
                "Sigues lanzando los dados.\n" +
                "Ganas si sacas el mismo numero que tu \"punto\".\n" +
                "Pierdes si sacas un 7 antes de tu punto.");

        boolean jugar = true;

        while (jugar) {
            System.out.println("Tu saldo actual es: $" + saldo);
            System.out.println("--- Nuevo Juego ---");
            System.out.println("Cuanto dinero deseas apostar?");
            double apuesta = scanner.nextDouble();
            scanner.nextLine();

            if (apuesta > saldo || apuesta <= 0) {
                System.out.println("Apuesta invalida. Debes apostar una cantidad positiva y no mayor a tu saldo.");
                continue;
            }

            System.out.println("Presiona 1 para tirar los dados o 2 para salir del juego.");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                int resultadoInicial = lanzarDados(random);
                System.out.println("Sacaste: " + resultadoInicial);

                if (resultadoInicial == 7 || resultadoInicial == 11) {
                    System.out.println("Ganaste en el tiro de salida!");
                    saldo += apuesta; // Gana la apuesta
                } else if (resultadoInicial == 2 || resultadoInicial == 3 || resultadoInicial == 12) {
                    System.out.println("Craps! Perdiste en el tiro de salida.");
                    saldo -= apuesta; // Pierde la apuesta
                } else {
                    System.out.println("Tu punto es: " + resultadoInicial);
                    int punto = resultadoInicial;
                    boolean seguirJugando = true;

                    while (seguirJugando) {
                        System.out.println("Presiona 1 para tirar los dados o 2 para salir del juego.");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == 1) {
                            int nuevoTiro = lanzarDados(random);
                            System.out.println("Sacaste: " + nuevoTiro);

                            if (nuevoTiro == punto) {
                                System.out.println("Ganaste al sacar tu punto de nuevo!");
                                saldo += apuesta; // Gana la apuesta
                                seguirJugando = false;
                            } else if (nuevoTiro == 7) {
                                System.out.println("Perdiste! Sacaste un 7 antes de tu punto.");
                                saldo -= apuesta; // Pierde la apuesta
                                seguirJugando = false;
                            }
                        } else if (opcion == 2) {
                            System.out.println("Has decidido salir del juego.");
                            seguirJugando = false;
                            jugar = false;
                        } else {
                            System.out.println("Opcion invalida. Intenta de nuevo.");
                        }
                    }
                }

                System.out.println("Tu saldo actual es: $" + saldo);

                if (saldo <= 0) {
                    System.out.println("Te has quedado sin saldo. El juego ha terminado.");
                    jugar = false;
                }

            } else if (opcion == 2) {
                System.out.println("Gracias por jugar. Hasta la proxima!");
                jugar = false;
            } else {
                System.out.println("Opcion invalida. Presiona 1 para tirar los dados o 2 para salir.");
            }
        }
    }

    private static int lanzarDados(Random random) {
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        return dado1 + dado2;
    }

    // Método para el juego de Ruleta
    public static void juegoRuleta(Scanner scanner) {
        Random random = new Random();
        System.out.println("Bienvenido a la Ruleta de Casino!");

        while (true) {
            System.out.println("Tu saldo actual es: $" + saldo);
            System.out.print("Cuántos dolares deseas apostar? ");
            double dineroApostado = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            if (dineroApostado > saldo || dineroApostado <= 0) {
                System.out.println("Apuesta invalida. Debes apostar una cantidad positiva y no mayor a tu saldo.");
                continue;
            }

            System.out.print("A que numero (0-36) o color (rojo/negro/verde) quieres apostar? ");
            String apuesta = scanner.nextLine().toLowerCase();

            int resultado = random.nextInt(37); // Genera un número del 0 al 36

            String colorResultado;
            // Asignar color al resultado
            if (resultado == 0) {
                colorResultado = "verde";
            } else if (resultado % 2 == 0) {
                colorResultado = "negro";
            } else {
                colorResultado = "rojo";
            }

            System.out.println("La ruleta ha salido el numero " + resultado + " (" + colorResultado + ").");

            // Verificar si el usuario ganó o perdió
            boolean ganador = false;
            double ganancia = 0.0;

            // Comprobar si la apuesta es un número
            if (apuesta.matches("\\d+") && Integer.parseInt(apuesta) >= 0 && Integer.parseInt(apuesta) <= 36) {
                int apuestaNumero = Integer.parseInt(apuesta);
                if (apuestaNumero == resultado) {
                    ganador = true;
                    ganancia = dineroApostado * 35; // Ganas 35 veces tu apuesta si aciertas el número
                }
            } else if (apuesta.equals("rojo") || apuesta.equals("negro") || apuesta.equals("verde")) {
                if (apuesta.equals(colorResultado)) {
                    ganador = true;
                    ganancia = dineroApostado * 2; // Ganas el doble si aciertas el color
                }
            } else {
                System.out.println("Apuesta invalida. Intenta de nuevo.");
                continue;
            }

            // Mostrar el resultado de la apuesta
            if (ganador) {
                System.out.println("Ganaste! Has ganado $" + ganancia);
                saldo += ganancia - dineroApostado; // Actualizar saldo
            } else {
                System.out.println("Perdiste $" + dineroApostado);
                saldo -= dineroApostado;
            }

            System.out.println("Tu saldo actual es: $" + saldo);

            if (saldo <= 0) {
                System.out.println("Te has quedado sin saldo. El juego ha terminado.");
                break;
            }

            // Preguntar si desea jugar de nuevo
            System.out.print("Quieres jugar de nuevo? (s/n): ");
            String jugarDeNuevo = scanner.nextLine().toLowerCase();
            if (!jugarDeNuevo.equals("s")) {
                break;
            }
        }

        System.out.println("Gracias por jugar a la Ruleta");
    }

    // Método para el juego de Tragamonedas
    public static void juegoTragamonedas(Scanner scanner) {
        System.out.println("Bienvenid@ a la maquina tragamonedas, Buena suerte!");
        System.out.println("-----------------------------------------------------------------------------");
        
        // Sistema de apuestas
        double apuesta;
        int Fig, Com;
        int Fig1 = 0, Fig2 = 0, Fig3 = 0;

        do {
            System.out.println("Tu saldo actual es: $" + saldo);
            System.out.println("Presiona 4 para jalar la palanca, 5 para dejar de jugar");
            Com = scanner.nextInt();
            
            if (Com == 4) {
                System.out.println("Cuanto deseas apostar? (En dolares):");
                apuesta = scanner.nextDouble();
                
                // Validación de la apuesta
                if (apuesta > saldo || apuesta < 0) {
                    System.out.println("Apuesta invalida. Debes apostar una cantidad positiva y no mayor a tu saldo.");
                    continue;
                }

                saldo -= apuesta; // Resta la apuesta al saldo
                
                for (int i = 1; i <= 3; i++) {
                    Fig = (int)(Math.random() * 5 + 1);
                    
                    if (i == 1) {
                        Fig1 = Fig;
                    } else if (i == 2) {
                        Fig2 = Fig;
                    } else if (i == 3) {
                        Fig3 = Fig;
                    }
                    
                    switch (Fig) {
                        case 1:
                            System.out.print("|Corazon|");
                            break;
                        case 2:
                            System.out.print("|Diamante|");
                            break;
                        case 3:
                            System.out.print("|Herradura|");
                            break;
                        case 4:
                            System.out.print("|Campana|");
                            break;
                        case 5:
                            System.out.print("|Limon|");
                            break;
                        default:
                            System.out.print("|Nada|");
                    }
                }
                System.out.println("\n-----------------------------------------------------------------------------");
                
                // Determinar resultados
                if ((Fig1 == Fig2) && (Fig2 == Fig3)) {
                    System.out.println("Felicidades, has ganado tu premio!");
                    saldo += apuesta * 5; // Gana 5 veces su apuesta
                } else if ((Fig1 == Fig2) || (Fig1 == Fig3) || (Fig2 == Fig3)) {
                    System.out.println("Casi lo logras, 2 iguales te dan otra oportunidad.");
                    saldo += apuesta; // Recupera la mitad de la apuesta
                } else {
                    System.out.println("Es una lastima, por favor vuelve a intentarlo.");
                }
            } else if (Com == 5) {
                System.out.println("Gracias por jugar!");
            } else {
                System.out.println("Debes pulsar 4 para seguir jugando o 5 para dejar de jugar.");
            }

            if (saldo <= 0) {
                System.out.println("Te has quedado sin saldo. El juego ha terminado.");
                break;
            }
        } while (Com != 5);
        
        System.out.println("Tu saldo final es: $" + saldo);
        
    }

    // Método para el juego de Carrera de Caballos
    public static void juegoCaballos(Scanner scanner) {
        System.out.println("Bienvenido a la carrera de caballos!");

        System.out.println("Tu saldo actual es: $" + saldo);
        System.out.print("Cuanto dinero deseas apostar? ");
        double apuesta = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        if (apuesta > saldo || apuesta <= 0) {
            System.out.println("Apuesta invalida. Debes apostar una cantidad positiva y no mayor a tu saldo.");
            return;
        }

        System.out.print("Ingrese el numero de caballos que participaran: ");
        int numCaballos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (numCaballos < 2) {
            System.out.println("Debe haber al menos 2 caballos en la carrera.");
            return;
        }

        ArrayList<Thread> hilos = new ArrayList<>();  // arraylist es para llamar un numero de elementos sin definir el tamaño- en este caso threads - hilos
        ArrayList<Caballo> caballos = new ArrayList<>();

        // Crear caballos
        for (int i = 0; i < numCaballos; i++) {
            System.out.print("Ingrese el nombre del caballo " + (i + 1) + ": ");
            String nombreCaballo = scanner.nextLine();
            Caballo caballo = new Caballo(nombreCaballo);
            caballos.add(caballo);
            hilos.add(new Thread(caballo));
        }

        // El jugador elige un caballo para apostar
        System.out.print("A que caballo deseas apostar? (ingresa el nombre exacto): ");
        String caballoApostado = scanner.nextLine();

        // Iniciar la carrera
        System.out.println("\nLa carrera ha comenzado!\n");
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los caballos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar un hilo: " + e.getMessage());
            }
        }

        // Determinar el ganador
        Caballo ganador = caballos.get(0);
        for (Caballo caballo : caballos) {
            if (caballo.getTiempo() < ganador.getTiempo()) {
                ganador = caballo;
            }
        }

        System.out.println("\nEl ganador es " + ganador.getNombre() + "!");

        // Verificar si el jugador ganó la apuesta
        if (ganador.getNombre().equalsIgnoreCase(caballoApostado)) {
            System.out.println("Felicidades! Tu caballo ha ganado. Has ganado $" + (apuesta * (numCaballos - 1)));
            saldo += apuesta * (numCaballos - 1); // Gana apuesta multiplicada por el número de caballos menos uno
        } else {
            System.out.println("Lo siento, tu caballo no gano. Has perdido tu apuesta de $" + apuesta);
            saldo -= apuesta;
        }

        System.out.println("Tu saldo actual es: $" + saldo);

        if (saldo <= 0) {
            System.out.println("Te has quedado sin saldo. El juego ha terminado.");
        }
    }

    // Clase Caballo modificada
    public static class Caballo implements Runnable {
        private String nombre;
        private int caminoRecorrido;
        private long tiempo;

        public Caballo(String nombre) {
            this.nombre = nombre;
            this.caminoRecorrido = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCaminoRecorrido() {
            return caminoRecorrido;
        }

        public long getTiempo() {
            return tiempo;
        }

        @Override
        public void run() {
            Random random = new Random();
            long inicio = System.currentTimeMillis();
            try {
                while (caminoRecorrido < 100) { // La meta es 100 unidades
                    int avance = random.nextInt(10) + 1; // Avanza de 1 a 10 unidades
                    caminoRecorrido += avance;
                    System.out.println(nombre + " ha avanzado " + avance + " unidades. Total: " + caminoRecorrido);

                    Thread.sleep(500); // Pausa de 0.5 segundos para simular el tiempo de carrera.
                }
                long fin = System.currentTimeMillis();
                tiempo = fin - inicio;
                System.out.println(nombre + " ha cruzado la meta con un tiempo de " + tiempo + " milisegundos.");
            } catch (InterruptedException ex) {
                System.out.println("Hilo interrumpido: " + nombre);
            }
        }
    }
}

