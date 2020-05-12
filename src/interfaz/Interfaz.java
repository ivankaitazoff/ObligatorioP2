/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Tablero;
import dominio.Jugador;
import dominio.Sistema;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    private static Sistema sistema = new Sistema();
    private static Tablero tablero = new Tablero();

    public static void menuPrincipal() {
        System.out.println("menu principal");
        menuOpciones();

    }

    public static void menuOpciones() {
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
                    agregarJugador();
                    break;
                case "B":
                    if (sistema.getListaJugadores().size() >= 2) {
                        nuevaPartida();
                        mostrarTablero(tablero.getTablero());
                    } else {
                        System.out.println("Error, no hay suficientes jugadores registrados");
                        System.out.println("");
                    }

                    // mostrarTablero(tablero.getTablero());
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

    public static void agregarJugador() {
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
        Jugador unJugador = new Jugador(nombre, edad, alias);
        sistema.guardarJugador(unJugador);

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

    public static void mostrarTablero(int[][] tablero) {
        int[][] tableroActualizado = tablero;
        for (int i = 0; i < tableroActualizado.length; i++) {
            System.out.println("");
            for (int j = 0; j < tableroActualizado[0].length; j++) {
                if (tableroActualizado[i][j] < 10) {
                    System.out.print(letrasVerdes + tableroActualizado[i][j] + "      " + resetearColorLetras);
                }
                if (tableroActualizado[i][j] < 21 && tableroActualizado[i][j] > 9) {
                    System.out.print(letrasVerdes + tableroActualizado[i][j] + "     " + resetearColorLetras);
                }
                if (tableroActualizado[i][j] == 21) {
                    System.out.print(letrasRojas + tableroActualizado[i][j] + "      " + resetearColorLetras);
                }
                if (tableroActualizado[i][j] == 22) {
                    System.out.print(letrasAzules + tableroActualizado[i][j] + "      " + resetearColorLetras);
                }
                // System.out.print(tableroActualizado[i][j] + "");
            }
        }
        System.out.println("");
    }

    public static void nuevaPartida() {
        Tablero tablero = new Tablero();
        System.out.println("Ingresar numero de jugador de la siguiente lista");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println("jugador numero:" + i + "-" + sistema.getListaJugadores().get(i));
        }

        //metodo para elegir el jugador1
        int numeroDeJugador1 = validacionNumero(0, sistema.getListaJugadores().size() - 1);
        tablero.setJugador1(sistema.getListaJugadores().get(numeroDeJugador1));
        System.out.println("Ingrese letra que represente al jugador 1");
        String letra1 = validarString();
        tablero.setLetraJugador1(letra1);

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
        tablero.setJugador2(sistema.getListaJugadores().get(numeroDeJugador2));
        System.out.println("Ingrese letra que represente al jugador 2");
        String letra2 = validarString();
        tablero.setLetraJugador2(letra2);

        System.out.println(tablero.getJugador1() + "Letra " + tablero.getLetraJugador1());
        System.out.println(tablero.getJugador2() + "Letra " + tablero.getLetraJugador2());
        System.out.println("");
        
    }

    public static final String resetearColorLetras = "\u001B[0m";
    public static final String letrasRojas = "\u001B[31m";
    public static final String letrasVerdes = "\u001B[32m";
    public static final String letrasAzules = "\u001B[34m";
}
