
package dominio;


public class Jugador {
    private String nombre;
    private int edad;
    private String alias;
    private String letraJugador;
    private int puntaje;

    public Jugador(String nombre, int edad, String alias, String letraJugador, int puntaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.alias = alias;
        this.letraJugador = letraJugador;
        this.puntaje = 0;
    }
     public Jugador(String nombre, int edad, String alias) {
        this.nombre = nombre;
        this.edad = edad;
        this.alias = alias;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLetraJugador() {
        return letraJugador;
    }

    public void setLetraJugador(String letraJugador) {
        this.letraJugador = letraJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", edad=" + edad + ", alias=" + alias + ", letraJugador=" + letraJugador + ", puntaje=" + puntaje + '}';
    }

    
    
}
