/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Sistema;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ivan
 */
public class Interfaz {
    private static Sistema system = new Sistema();
    
    public static void menuPrincipal(){
        
        
        System.out.println("menu principal");
        //crear jugador
        crearJugador();
    }
    
    public static void crearJugador(){
        System.out.println("Ingresar nombre");
        String nombre=validarString();
        System.out.println("Ingresar edad");
        int edad=validacionNumero(10, 100);
        System.out.println("Ingresar alias");
        String alias=validarString();
        
        //imprimir datos
        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(alias);
        
    }
    
    public static String validarString(){
    Scanner scanner= new Scanner(System.in);
    String dato=scanner.nextLine();
    return dato;
    }
    
    /* public static int validarNumero(int minimo, int maximo){
        int numero=0;
        Boolean datoValido = false;
        Scanner scanner= new Scanner(System.in);
        while(!datoValido){
            try {
                numero=scanner.nextInt();
                //if (numero >= minimo && numero <= maximo) {
                    //return numero;
                //} else {
                    //Toolkit.getDefaultToolkit().beep();  
                //    System.out.print("Error, ingrese un valor entre: " + minimo + " y " + maximo + ": ");
                //}
            } 
            catch (Exception e) {
                System.out.println("Error, numero mal ingresado");
                scanner.nextLine();
                numero=scanner.nextInt();
            }
        }
    return numero;
    }   */
    
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
    
    
    
}
