/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriop2;

import dominio.Sistema;
import java.util.ArrayList;

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
        Jugador jugador = new Jugador();
        
    }
}
