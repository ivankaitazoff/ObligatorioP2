package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Jugador> listaJugadores=new ArrayList<>();
    private Jugador jugadorActual;

    public void guardarJugador(Jugador unJugador) {
        listaJugadores.add(unJugador);
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i));
        }
    }
}
