/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author ivan
 */
public class Juego {
    
        int [][] tablero={{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}};
    
        public void mostrarTablero(){
        int [][] tableroActualizado = tablero;
        for (int i = 0; i < tableroActualizado.length; i++) {
            System.out.println("");
            for (int j = 0; j < tableroActualizado[0].length; j++) {
                if (tableroActualizado[i][j]<21) {
                    System.out.print(tableroActualizado[i][j] + "");
                }
                System.out.print(tableroActualizado[i][j] + "");
            }
        }
        System.out.println("");
        }
}
