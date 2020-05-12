package dominio;

public class Tablero {
    private int [] dados = new int[5];
    private int[][] tablero = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
    {16, 17, 18, 19, 20}};

    private Jugador jugador1;
    private Jugador jugador2;
    
    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int[] getDados() {
        return dados;
    }

    //Set dados solo se usa para modo test
    public void setDados(int[] dados) {
        this.dados = dados;
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
    public int[] generarDadosRandom(){
        for (int i = 0; i < dados.length; i++) {
            int valorDado = (int) Math.floor(Math.random()*6+1);
            dados[i] = valorDado;
        }
        return dados;
    }
    
}
