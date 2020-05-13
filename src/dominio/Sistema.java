package dominio;

import java.util.ArrayList;

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
}
