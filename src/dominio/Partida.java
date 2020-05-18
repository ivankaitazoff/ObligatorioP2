package dominio;

public class Partida {
    private int [] dados = new int[5];
    private int[][] tableroActual = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
    {16, 17, 18, 19, 20}};
    private Jugador jugador1;
    String letraJugador1;
    private Jugador jugador2;
    String letraJugador2;
    
    public int[][] getTablero() {
        return tableroActual;
    }

    public void setTablero(int[][] tablero) {
        this.tableroActual = tableroActual;
    }
    
    public void setJugadaJug1(int[][] tablero, int fila, int columna) {
        this.tableroActual[fila][columna] = 21;
    }
    
    public void setJugadaJug2(int[][] tablero, int fila, int columna) {
        this.tableroActual[fila][columna] = 22;
    }

    public int[] getDados() {
        return dados;
    }

    //Set dados solo se usa para modo test
    public void setDados(int[] dados) {
        this.dados = dados;
    }
    public int[] setDadosRandom(){
        for (int i = 0; i < dados.length; i++) {
            int valorDado = (int) (Math.floor(Math.random()*6)+1);
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

    
    
}
