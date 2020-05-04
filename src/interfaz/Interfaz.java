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
    private static Tablero tablero=new Tablero();
    public static void menuPrincipal() {
        mostrarTablero(tablero.getTablero());
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

            System.out.println("Elija la opcion");
            opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "A":
                    System.out.println("Registro de jugadores");
                    System.out.println("");
                    agregarJugador();
                    break;
                case "B":
                    System.out.println("Jugar");
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
      
        Jugador unJugador=new Jugador(nombre, edad, alias,"e",0);
        sistema.guardarJugador( unJugador);
        
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

    public static void mostrarTablero(int[][] tablero ) {
        int[][] tableroActualizado = tablero;
        for (int i = 0; i < tableroActualizado.length; i++) {
            System.out.println("");
            for (int j = 0; j < tableroActualizado[0].length; j++) {
                if (tableroActualizado[i][j] < 21) {
                    System.out.print(letrasVerdes+tableroActualizado[i][j] + ""+resetearColorLetras);
                }
                 if (tableroActualizado[i][j] == 21) {
                    System.out.print(letrasRojas+tableroActualizado[i][j] + ""+resetearColorLetras);
                }
                  if (tableroActualizado[i][j] == 22) {
                    System.out.print(letrasAzules+tableroActualizado[i][j] + ""+resetearColorLetras);
                }
               // System.out.print(tableroActualizado[i][j] + "");
            }
        }
        System.out.println("");
    }
    public static final String resetearColorLetras = "\u001B[0m";
    public static final String letrasRojas = "\u001B[31m";
    public static final String letrasVerdes = "\u001B[32m";
    public static final String letrasAzules = "\u001B[34m";
}
