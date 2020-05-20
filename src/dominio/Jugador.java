
package dominio;


public class Jugador {
    private String nombre;
    private int edad;
    private String alias;
    private int partidasJugadas;
    private int partidasGanadas;

    public Jugador(String nombre, int edad, String alias) {
        this.nombre = nombre;
        this.edad = edad;
        this.alias = alias;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
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

    public int getPuntaje() {
        return partidasJugadas;
    }

    public void setPuntaje(int puntaje) {
        this.partidasJugadas = puntaje;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", alias=" + alias +", partidas jugadas="+ partidasJugadas + ", partidas ganadas= "+ partidasGanadas+'}';
    }
    
    
    
}
