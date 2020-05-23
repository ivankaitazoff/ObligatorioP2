/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Partida;
import dominio.Jugador;
import dominio.Sistema;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Interfaz {

    public static void menuPrincipal() {
        Sistema sistema = new Sistema();
        System.out.println("menu principal");
        menuOpciones(sistema);
    }

    public static void menuOpciones(Sistema sistema) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("A-Registrar jugador");
            System.out.println("B-Jugar a 'sumas'");
            System.out.println("C-Ver ranking de jugadores");
            System.out.println("D-Terminar");

            System.out.println(" ");

            System.out.println("Elija la opcion");
            opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "A":
                    System.out.println("Registro de jugadores");
                    System.out.println("");
                    agregarJugador(sistema);
                    break;
                case "B":
                    if (sistema.getListaJugadores().size() >= 2) {
                        nuevaPartida(sistema);
                    } else {
                        System.out.println("Error, no hay suficientes jugadores registrados");
                        System.out.println("");
                    }
                    break;
                case "C":
                    System.out.println("");
                    System.out.println("Ranking de jugadores");
                    Collections.sort(sistema.getListaJugadores());
                    for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
                        System.out.println(i + 1 + ") " + sistema.getListaJugadores().get(i));
                    }
                    System.out.println("");
                    break;
                case "D":
                    salir = true;
                    System.out.println("Juego terminado");
                    break;
                default:
                    System.out.println("ingrese la opcion correcta ");
            }

        }

    }

    public static void agregarJugador(Sistema sistema) {
        System.out.println("Ingresar nombre");
        String nombre = sistema.validarString();
        System.out.println("Ingresar edad");
        int edad = sistema.validacionNumero(10, 100);
        System.out.println("Ingresar alias");
        String alias = sistema.validarString();
        while (sistema.aliasRepetidos(alias)) {
            System.out.println("Alias repetido ingresar otro");
            alias = sistema.validarString();
        }
        sistema.guardarJugador(nombre, edad, alias);
    }

    public static void mostrarTablero(Partida partida) {
        for (int i = 0; i < partida.getTablero().length; i++) {
            System.out.println("");
            for (int j = 0; j < partida.getTablero()[0].length; j++) {
                if (partida.getTablero()[i][j] < 10) {
                    System.out.print(letrasVerdes + partida.getTablero()[i][j] + "      " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] < 21 && partida.getTablero()[i][j] > 9) {
                    System.out.print(letrasVerdes + partida.getTablero()[i][j] + "     " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] == 21) {
                    System.out.print(letrasRojas + partida.getLetraJugador1() + "      " + resetearColorLetras);
                }
                if (partida.getTablero()[i][j] == 22) {
                    System.out.print(letrasAzules + partida.getLetraJugador2() + "      " + resetearColorLetras);
                }
            }
        }
        System.out.println("");
    }

    public static void nuevaPartida(Sistema sistema) {
        Partida partida = new Partida();
        System.out.println("Ingresar numero de jugador de la siguiente lista");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println("jugador numero:" + i + "-" + sistema.getListaJugadores().get(i));
        }
        //metodo para elegir el jugador1
        int numeroDeJugador1 = sistema.validacionNumero(0, sistema.getListaJugadores().size() - 1);
        partida.setJugador1(sistema.getListaJugadores().get(numeroDeJugador1));
        int partidasJugadasJ1 = partida.getJugador1().getPartidasJugadas();
        partida.getJugador1().setPartidasJugadas(partidasJugadasJ1 + 1);

        System.out.println("Ingrese una letra que represente al jugador 1");
        String letra1 = sistema.validarString();

        while (letra1.length() != 1) {
            System.out.println("vuelva a ingresar solo una letra ");
            letra1 = sistema.validarString();
        }
        partida.setLetraJugador1(letra1);

        //metodo para elegir el jugador2
        System.out.println("Ingresar numero de jugador de la siguiente lista");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println("jugador numero:" + i + "-" + sistema.getListaJugadores().get(i));
        }
        int numeroDeJugador2 = sistema.validacionNumero(0, sistema.getListaJugadores().size() - 1);
        while (numeroDeJugador2 == numeroDeJugador1) {
            System.out.println("Ingrese un numero jugador que no este seleccionado");
            numeroDeJugador2 = sistema.validacionNumero(0, sistema.getListaJugadores().size() - 1);
        }
        partida.setJugador2(sistema.getListaJugadores().get(numeroDeJugador2));
        int partidasJugadasJ2 = partida.getJugador2().getPartidasJugadas();
        partida.getJugador2().setPartidasJugadas(partidasJugadasJ2 + 1);

        System.out.println("Ingrese una letra que represente al jugador 2");
        String letra2 = sistema.validarString();

        while (letra2.length() != 1) {
            System.out.println("vuelva a ingresar solo una letra ");
            letra2 = sistema.validarString();
        }
        partida.setLetraJugador2(letra2);

        System.out.println(partida.getJugador1() + "Letra " + partida.getLetraJugador1());
        System.out.println(partida.getJugador2() + "Letra " + partida.getLetraJugador2());
        System.out.println("");

        System.out.println("En caso de querer utilizar modo test ingresar 'TEST', en caso de no querer");
        String modoTest = sistema.validarString();
        boolean test = false;
        if (modoTest.equalsIgnoreCase("TEST")) {
            test = true;
        }

        menuPartida(sistema, partida, test);
    }

    public static void menuPartida(Sistema sistema, Partida partida, boolean test) {
        boolean terminarPartida = false;
        boolean partidaAbandonada = false;
        boolean fichaColocada = true;
        String opcion;
        int turno = 1;
        int puntosJug1=0;
        int puntosJug2=0;
        while (!terminarPartida) {
            mostrarTablero(partida);
            
            if (test == true && fichaColocada == true) {
                System.out.println("LA PARTIDA SE ENCUENTRA EN MODO TEST, INGRESAR DADOS DE A UNO");
                partida.setDadosTest(partida, sistema);
            } else if (test != true && fichaColocada == true) {
                partida.setDadosRandom();
            }
            puntosJug1 = partida.puntosJugadorUno(partida, 21);
            puntosJug2 = partida.puntosJugadorUno(partida, 22);
            System.out.println("Puntos del jugador 1: " + puntosJug1);
            System.out.println("Puntos del jugador 2: " + puntosJug2);
            mostrarDados(partida);
            fichaColocada = false;

            System.out.println("P-Pasar de turno ");
            System.out.println("0-Utilizar solamente dado base");
            System.out.println("C-Utilizar alguno/s de los extras");
            System.out.println("X-Abandonar partida");
            System.out.println("A-Ayuda");
            if (turno % 2 == 1) {
                System.out.println("Turno de jugador 1");
            } else {
                System.out.println("Turno de jugador 2");
            }

            System.out.println(" ");

            System.out.println("Elija la opcion");
            opcion = sistema.validarString().toUpperCase();

            switch (opcion) {
                case "P":
                    fichaColocada = true;
                    turno++;
                    break;
                case "0":
                    for (int i = 0; i < partida.getTablero().length; i++) {
                        for (int j = 0; j < partida.getTablero()[0].length; j++) {
                            if (partida.getDados()[0] == partida.getTablero()[i][j] && turno % 2 == 1) {
                                partida.setJugadaJug1(partida.getTablero(), i, j);
                                fichaColocada = true;
                                break;
                            } else if (partida.getDados()[0] == partida.getTablero()[i][j] && turno % 2 == 0) {
                                partida.setJugadaJug2(partida.getTablero(), i, j);
                                fichaColocada = true;
                            }
                        }
                    }
                    if (!fichaColocada) {
                        System.out.println("Error, no esta libre esa posicion");
                        System.out.println("Vuelva a ingresar su jugada");
                    } else {
                        turno++;
                    }
                    break;
                case "C":
                    try {
                        System.out.println("Ingrese dados extra que se quieran utilizar");
                        String dados = sistema.validarString();
                        String[] arrayStringDados = dados.split(" ");
                        boolean dadoExiste = false;
                        int[] dadosSinUsar = new int[5];
                        for (int i = 0; i < partida.getDados().length; i++) {
                            dadosSinUsar[i] = partida.getDados()[i];
                        }
                        int[] arrayIntDados = new int[arrayStringDados.length];
                        int sumaDados = partida.getDados()[0];
                        for (int i = 0; i < arrayIntDados.length; i++) {
                            dadoExiste = false;
                            arrayIntDados[i] = Integer.parseInt(arrayStringDados[i]);
                            while (arrayIntDados[i] < 1 || arrayIntDados[i] > 6) {
                                System.out.println("Error, los valores ingresados deben ser entre 1 y 6(incluidos)");
                                arrayIntDados[i] = sistema.validacionNumero(1, 6);
                            }
                            for (int j = 1; j < dadosSinUsar.length; j++) {
                                if (arrayIntDados[i] == dadosSinUsar[j]) {
                                    dadosSinUsar[j] = 0;
                                    dadoExiste = true;
                                    sumaDados = sumaDados + arrayIntDados[i];
                                    break;
                                }
                            }
                            if (!dadoExiste) {
                                System.out.println("Error, dados ingresados no corresponden con posibles opciones");
                                break;
                            }
                        }

                        if (dadoExiste && sumaDados <= 20) {
                            for (int i = 0; i < partida.getTablero().length; i++) {
                                for (int j = 0; j < partida.getTablero()[0].length; j++) {
                                    if (sumaDados == partida.getTablero()[i][j] && turno % 2 == 1) {
                                        partida.setJugadaJug1(partida.getTablero(), i, j);
                                        fichaColocada = true;
                                        break;
                                    } else if (sumaDados == partida.getTablero()[i][j] && turno % 2 == 0) {
                                        partida.setJugadaJug2(partida.getTablero(), i, j);
                                        fichaColocada = true;
                                    }
                                }
                            }
                            turno++;
                        }

                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;

                case "X":
                    if (turno % 2 == 1) {
                        int partidasGanadasJ2 = partida.getJugador2().getPartidasGanadas();
                        partida.getJugador2().setPartidasGanadas(partidasGanadasJ2 + 1);

                    } else {
                        int partidasGanadasJ1 = partida.getJugador1().getPartidasGanadas();
                        partida.getJugador1().setPartidasGanadas(partidasGanadasJ1 + 1);
                    }
                    terminarPartida = true;
                    partidaAbandonada = true;
                    break;
                case "A":
                    String ayuda = partida.pedidoAyuda(partida);
                    System.out.println(ayuda);
                    break;
            }
            if (!terminarPartida) {
                terminarPartida=partida.tableroLleno(partida);
                }           
        }
        if (partidaAbandonada == false && terminarPartida) {
                    if (puntosJug1 > puntosJug2) {
                        int partidasGanadasJ1 = partida.getJugador1().getPartidasGanadas();
                        partida.getJugador1().setPartidasGanadas(partidasGanadasJ1 + 1);
                        System.out.println("Juego terminado, ganador jugador 1 con: "+puntosJug1+" puntos");
                    }
                    else if(puntosJug2 > puntosJug1){
                        int partidasGanadasJ2 = partida.getJugador2().getPartidasGanadas();
                        partida.getJugador2().setPartidasGanadas(partidasGanadasJ2 + 1);
                        System.out.println("Juego terminado, ganador jugador 2 con: "+puntosJug2+" puntos");
                    }
                }
        System.out.println("");
    }

    public static void mostrarDados(Partida partida) {
        System.out.print("Dados:  ");
        for (int i = 0; i < partida.getDados().length; i++) {
            System.out.print(partida.getDados()[i] + "   ");
        }
        System.out.println("");
    }

    public static final String resetearColorLetras = "\u001B[0m";
    public static final String letrasRojas = "\u001B[31m";
    public static final String letrasVerdes = "\u001B[32m";
    public static final String letrasAzules = "\u001B[34m";
}
