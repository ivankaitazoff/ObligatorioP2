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
public class Jugador {
    private String nombre;
    private int edad;
    private String alias;
    private char letraJugador;
    private int puntaje;

    public Jugador(String nombre, int edad, String alias, char letraJugador, int puntaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.alias = alias;
        this.letraJugador = letraJugador;
        this.puntaje = 0;
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

    public char getLetraJugador() {
        return letraJugador;
    }

    public void setLetraJugador(char letraJugador) {
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
