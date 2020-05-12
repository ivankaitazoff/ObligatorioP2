package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Jugador> listaJugadores=new ArrayList<>();
    
    
    //metodo que verifica que el alias no este repetido
    public boolean aliasRepetidos(String alias ){
    boolean repetido=false;    
    for (int i = 0; i < listaJugadores.size(); i++) {
            if(listaJugadores.get(i).getAlias().equals(alias)){
               repetido=true; 
            }
            
        }
    return repetido;
    }
    
    //metodo que recibe jugador y lo guarla en la lista de jugadores(listaJugadores)
    public void guardarJugador(Jugador unJugador) {
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
