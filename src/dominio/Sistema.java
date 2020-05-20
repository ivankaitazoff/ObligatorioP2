package dominio;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Jugador> listaJugadores;//=new ArrayList<>();

    public Sistema() {
        listaJugadores = new ArrayList();
    }

    public boolean aliasRepetidos(String alias) {
        //metodo que verifica que el alias no este repetido
        boolean repetido = false;
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getAlias().equals(alias)) {
                repetido = true;
            }

        }
        return repetido;
    }

    //metodo que recibe jugador y lo guarla en la lista de jugadores(listaJugadores)
    public void guardarJugador(String nombre, int edad, String alias) {
        Jugador unJugador = new Jugador(nombre, edad, alias);
        listaJugadores.add(unJugador);
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i));
        }
        System.out.println("");
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
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
    
    
}
