/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Partida;
import dominio.Jugador;
import dominio.Sistema;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    public static void menuPrincipal() {
        Sistema sistema = new Sistema();
        System.out.println("menu principal");
        menuOpciones(sistema);
    }

    public static void menuOpciones(Sistema sistema) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("A-Registrar jugador");
            System.out.println("B-Jugar a 'sumas'");
            System.out.println("C-Dar ranking de jugadores");
            System.out.println("D-Terminar");

            System.out.println(" ");

            System.out.println("Elija la opcion");
            opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "A":
                    System.out.println("Registro de jugadores");
                    System.out.println("");
                    agregarJugador(sistema);
                    break;
                case "B":
                    if (sistema.getListaJugadores().size() >= 2) {
                        nuevaPartida(sistema);
                    } else {
                        System.out.println("Error, no hay suficientes jugadores registrados");
                        System.out.println("");
                    }
                    break;
                case "C":
                    System.out.println("Ver ranking de jugadores");
                    break;
                case "D":
                    salir = true;
                    System.out.println("Juego terminado");
                    break;
                default:
                    System.out.println("ingrese la opcion correcta ");
            }

        }

    }

    public static void agregarJugador(Sistema sistema) {
        System.out.println("Ingresar nombre");
        String nombre = validarString();
        System.out.println("Ingresar edad");
        int edad = validacionNumero(10, 100);
        System.out.println("Ingresar alias");
        String alias = validarString();
        while (sistema.aliasRepetidos(alias)) {
            System.out.println("Alias repetido ingresar otro");
            alias = validarString();
        }
        sistema.guardarJugador(nombre, edad, alias);

    }

    public static String validarString() {
        Scanner scanner = new Scanner(System.in);
        String dato = scanner.nextLine();
        return dato;
    }

    public static int validacionNumero(int min, int max) {
        boolean ok = false;
        while (!ok) {
            String palabra = validarString();
            try {
                int num = Integer.parseInt(palabra);
                if (num >= min && num <= max) {
                    return num;
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.print("Error, ingrese un valor entre: " + min + " y " + max + ": ");
                }
            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                System.out.print("Error, tipo de dato incorrecto, volver a ingresar: ");
            }
        }
        return 0;
    }

    public static void mostrarTablero(Partida partida) {
        for (int i = 0; i < partida.getTablero().length; i++) {
            System.out.println("");
            for (int j = 0; j < partida.getTablero()[0].length; j++) {
                if (partida.getTablero()[i][j] < 10) {
                    System.out.print(letrasVerdes + partida.getTablero()[i][j] + "      " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] < 21 && partida.getTablero()[i][j] > 9) {
                    System.out.print(letrasVerdes + partida.getTablero()[i][j] + "     " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] == 21) {
                    System.out.print(letrasRojas + partida.getLetraJugador1() + "      " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] == 22) {
                    System.out.print(letrasAzules + partida.getLetraJugador2() + "      " + resetearColorLetras);
                }
            }
        }
        System.out.println("");
    }

    public static void nuevaPartida(Sistema sistema) {
        Partida partida = new Partida();
        System.out.println("Ingresar numero de jugador de la siguiente lista");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println("jugador numero:" + i + "-" + sistema.getListaJugadores().get(i));
        }

        //metodo para elegir el jugador1
        int numeroDeJugador1 = validacionNumero(0, sistema.getListaJugadores().size() - 1);
        partida.setJugador1(sistema.getListaJugadores().get(numeroDeJugador1));
        System.out.println("Ingrese letra que represente al jugador 1");
        String letra1 = validarString();
        partida.setLetraJugador1(letra1);

        //metodo para elegir el jugador2
        System.out.println("Ingresar numero de jugador de la siguiente lista");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println("jugador numero:" + i + "-" + sistema.getListaJugadores().get(i));
        }
        int numeroDeJugador2 = validacionNumero(0, sistema.getListaJugadores().size() - 1);
        while (numeroDeJugador2 == numeroDeJugador1) {
            System.out.println("Ingrese un numero jugador que no este seleccionado");
            numeroDeJugador2 = validacionNumero(0, sistema.getListaJugadores().size() - 1);
        }
        partida.setJugador2(sistema.getListaJugadores().get(numeroDeJugador2));
        System.out.println("Ingrese letra que represente al jugador 2");
        String letra2 = validarString();
        partida.setLetraJugador2(letra2);

        System.out.println(partida.getJugador1() + "Letra " + partida.getLetraJugador1());
        System.out.println(partida.getJugador2() + "Letra " + partida.getLetraJugador2());
        System.out.println("");

        partida.setJugadaJug1(partida.getTablero(), 2, 3);
        partida.setJugadaJug2(partida.getTablero(), 2, 2);

        mostrarTablero(partida);
        //Metodo que setea los dador random y los muestra
        partida.setDadosRandom();
        System.out.print("Dados:  ");
        for (int i = 0; i < partida.getDados().length; i++) {
            System.out.print(partida.getDados()[i] + "   ");
        }
        System.out.println("");
    }

    public void setDados(Partida partida) {
        Scanner scanner = new Scanner(System.in);
        int[] dados = new int[5];
        for (int i = 0; i < 5; i++) {
            int valorDado = validacionNumero(1, 6);
            dados[i] = valorDado;
        }
        partida.setDados(dados);
    }

    public void menuPartida() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("P-Pasar de turno ");
            System.out.println("0-Utilizar solamente dado base");
            System.out.println("C-Uutilizar alguno/s de los extras");
            System.out.println("X-Abandonar partida");
            System.out.println("A-Ayuda");
            int turno = 1;
            if (turno % 2 == 1) {
                System.out.println("Turno de jugador 1");
            } else {
                System.out.println("Turno de jugador 2");

            }

            System.out.println(" ");

            System.out.println("Elija la opcion");
            opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "P":
                    turno++;
                    break;
                case "0":
                   
                    
                    turno++;

                    break;
                case "C":
                   
                    
                    turno++;

                    break;
                case "X":

                    break;
                case "A":

                    break;
            }
        }

    }
    public static final String resetearColorLetras = "\u001B[0m";
    public static final String letrasRojas = "\u001B[31m";
    public static final String letrasVerdes = "\u001B[32m";
    public static final String letrasAzules = "\u001B[34m";
}
