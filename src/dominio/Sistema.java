package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Jugador> listaJugadores=new ArrayList<>();
   
    private Jugador jugadorActual;
    
    public boolean aliasRepetidos(String alias ){
    boolean repetido=false;    
    for (int i = 0; i < listaJugadores.size(); i++) {
            if(listaJugadores.get(i).getAlias().equals(alias)){
               repetido=true; 
            }
            
        }
    return repetido;
    }
    
    public void guardarJugador(Jugador unJugador) {
        listaJugadores.add(unJugador);
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i));
        }
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
    
}
