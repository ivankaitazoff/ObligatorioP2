//Nombres y numeros de estudiantes
//Ivan kaitazoff: 233940
//Sebastian Romelli: 222405
package dominio;

import java.util.Scanner;

public class Partida {

    private int[] dados = new int[5];
    private int[][] tablero = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
    {16, 17, 18, 19, 20}};
    private Jugador jugador1;
    private String letraJugador1;
    private Jugador jugador2;
    private String letraJugador2;

    public int[][] getTablero() {
        return tablero;
    }

    public void setJugadaJug1(int[][] tablero, int fila, int columna) {
        this.tablero[fila][columna] = 21;
    }

    public void setJugadaJug2(int[][] tablero, int fila, int columna) {
        this.tablero[fila][columna] = 22;
    }

    public int[] getDados() {
        return dados;
    }

    //Set dados solo se usa para modo test
    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public void setDadosTest(Sistema sistema) {
        int[] dados = new int[5];
        for (int i = 0; i < 5; i++) {
            int valorDado = sistema.validacionNumero(1, 6);
            dados[i] = valorDado;
        }
        setDados(dados);
    }

    public int[] setDadosRandom() {
        for (int i = 0; i < dados.length; i++) {
            int valorDado = (int) (Math.floor(Math.random() * 6) + 1);
            dados[i] = valorDado;
        }
        return dados;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public String getLetraJugador1() {
        return letraJugador1;
    }

    public void setLetraJugador1(String letraJugador1) {
        this.letraJugador1 = letraJugador1;
    }

    public String getLetraJugador2() {
        return letraJugador2;
    }

    public void setLetraJugador2(String letraJugador2) {
        this.letraJugador2 = letraJugador2;
    }

    public boolean posicionLibreMetodo(boolean posicionLibre, int posibleSolucion) {
        for (int j = 0; j < getTablero().length; j++) {
            if (posicionLibre) {
                break;
            }
            for (int k = 0; k < getTablero()[0].length; k++) {
                if (getTablero()[j][k] == posibleSolucion) {
                    posicionLibre = true;

                    break;
                }
            }
        }
        return posicionLibre;
    }

    public String pedidoAyuda() {
        String texto = "No hay jugadas posibles";;
        int posibleSolucion = 0;
        boolean posicionLibre = false;
        //calculo para usar 1 dado extra
        for (int i = 1; i < getDados().length; i++) {
            if (posicionLibre) {
                break;
            }
            posibleSolucion = getDados()[0] + getDados()[i];
            posicionLibre = posicionLibreMetodo(posicionLibre, posibleSolucion);
            if (posicionLibre) {
                texto = "Posible solucion es utilizar posicion: "
                        + posibleSolucion + ",ingresando: "
                        + getDados()[i];
            }
        }
        //calculo para el caso de usar 2 dados extra
        if (posicionLibre == false) {
            for (int i = 1; i < getDados().length; i++) {
                if (posicionLibre) {
                    break;
                }
                for (int j = 1; j < getDados().length; j++) {
                    if (i != j) {
                        posibleSolucion = getDados()[0] + getDados()[i] + getDados()[j];
                    }
                    posicionLibre = posicionLibreMetodo(posicionLibre, posibleSolucion);
                    if (posicionLibre) {
                        texto = "Posible solucion es utilizar posicion: "
                                + posibleSolucion + ",ingresando: "
                                + getDados()[i] + " " + getDados()[j];
                        break;
                    }
                }
            }
            //en caso de utilizar 3 dados extra
            for (int i = 1; i < getDados().length; i++) {
                if (posicionLibre) {
                    break;
                }
                for (int j = 1; j < getDados().length; j++) {
                    if (posicionLibre) {
                        break;
                    }
                    for (int k = 1; k < getDados().length; k++) {
                        if (i != j && i != k && j != k) {
                            posibleSolucion = getDados()[0] + getDados()[i] + getDados()[j]
                                    + getDados()[k];
                        }
                        if (posibleSolucion <= 20) {
                            posicionLibre = posicionLibreMetodo(posicionLibre, posibleSolucion);
                            if (posicionLibre) {
                                texto = "Posible solucion es utilizar posicion: "
                                        + posibleSolucion + ",ingresando: "
                                        + getDados()[i] + " " + getDados()[j] + " "
                                        + getDados()[k];
                                break;
                            }
                        }
                    }
                }
            }
            //en caso de utilizar 4 dados extra
            if (posicionLibre == false) {
                posibleSolucion = getDados()[0] + getDados()[1] + getDados()[2]
                        + getDados()[3] + getDados()[4];
                if (posibleSolucion <= 20) {
                    posicionLibre = posicionLibreMetodo(posicionLibre, posibleSolucion);
                    if (posicionLibre) {
                        texto = "Posible solucion es utilizar posicion: "
                                + posibleSolucion + ",ingresando: "
                                + getDados()[1] + " " + getDados()[2] + " "
                                + getDados()[3] + " " + getDados()[4];
                    }

                }
            }
        }
        return texto;
    }

    public boolean tableroLleno(Partida partida) {
        boolean tableroLleno = true;
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero()[0].length; j++) {
                if (getTablero()[i][j] <= 20) {
                    tableroLleno = false;
                    break;
                }

            }
            if (tableroLleno == false) {
                break;
            }
        }
        return tableroLleno;
    }

    public int contadorPuntos(int x) {
        int puntos = 0;
        int contador = 0;
        //recorre y cuenta los puntos en las filas
        for (int i = 0; i < getTablero().length; i++) {
            for (int j = 0; j < getTablero()[0].length; j++) {
                if (getTablero()[i][j] == x) {
                    contador++;
                }
                if (getTablero()[i][j] != x && contador >= 3 || j == getTablero()[0].length - 1 && contador >= 3) {
                    puntos = puntos + contador;
                    contador = 0;
                }
                if (getTablero()[i][j] != x && contador < 3 || j == getTablero()[0].length - 1 && contador < 3) {
                    contador = 0;
                }
            }
        }
        //recorre y cuenta los puntos en las columnas
        for (int i = 0; i < getTablero()[0].length; i++) {
            for (int j = 0; j < getTablero().length; j++) {
                if (getTablero()[j][i] == x) {
                    contador++;
                }
                if (getTablero()[j][i] != x && contador >= 3 || j == getTablero().length - 1 && contador >= 3) {
                    puntos += contador;
                    contador = 0;
                }
                if (getTablero()[j][i] != x && contador < 3 || j == getTablero().length - 1 && contador < 3) {
                    contador = 0;
                }
            }
        }
        //recorre diagonales paralelas a la principal(de izquierda a derecha)
        for (int k = -1; k < 3; k++) {
            for (int i = 0; i < getTablero().length; i++) {
                for (int j = 0; j < getTablero()[0].length; j++) {
                    if (j - i == k) {
                        if (getTablero()[i][j] == x) {
                            contador++;
                        }
                        if (getTablero()[i][j] != x && contador >= 3) {
                            puntos += contador;
                            contador = 0;
                        }
                        if (getTablero()[i][j] != x && contador < 3) {
                            contador = 0;
                        }
                    }

                }
            }
            if (contador >= 3) {
                puntos += contador;
            }
            contador = 0;
        }

        //recorre diagonales perpendiculares de la principal
        for (int k = 2; k < 6; k++) {
            for (int i = 0; i < getTablero().length; i++) {
                for (int j = 0; j < getTablero()[0].length; j++) {
                    if (j + i == k) {
                        if (getTablero()[i][j] == x) {
                            contador++;
                        }
                        if (getTablero()[i][j] != x && contador >= 3) {
                            puntos += contador;
                            contador = 0;
                        }
                        if (getTablero()[i][j] != x && contador < 3) {
                            contador = 0;
                        }
                    }

                }
            }
            if (contador >= 3) {
                puntos += contador;
            }
            contador = 0;
        }

        return puntos;
    }

}
