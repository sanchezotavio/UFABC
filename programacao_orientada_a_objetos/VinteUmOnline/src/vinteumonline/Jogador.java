package VinteUmOnline;

import java.util.ArrayList;

public  class Jogador {

    public String Nome;
    protected String IP;
    public int ID;
    public ArrayList<Carta> maoJogador = new ArrayList();
    protected int maoPosicao = 0;
    public boolean fim = false;
    public int posicaoMesa;
    public int Pontos;
    private int Vitorias;
    private int Derrotas = 0;

    Jogador(String Nome, int ID, int posicaoMesa) {
        this.Nome = Nome;
        this.ID = ID;
        this.posicaoMesa = posicaoMesa;
    }

     
    public void Mao(Carta Carta) {
        maoJogador.add(Carta);
    }

    public void Parar() {
        fim = true;
    }

    public void Iniciar(Baralho Baralho) {
        fim = false;
        for (int i = 0; i < 2; i++) {
            int posicao = Baralho.proxima();
            int Naipe = Baralho.atrCarta.get(posicao).Naipe;
            int Valor = Baralho.atrCarta.get(posicao).Valor;
            int numCarta = Baralho.atrCarta.get(posicao).numCarta;
            Carta cartaAtual = new Carta(Naipe, Valor, numCarta);
            Mao(cartaAtual);
        }
    }

    public void Continuar(Baralho Baralho) {
        int posicao = Baralho.proxima();
        int Naipe = Baralho.atrCarta.get(posicao).Naipe;
        int Valor = Baralho.atrCarta.get(posicao).Valor;
        int numCarta = Baralho.atrCarta.get(posicao).numCarta;
        Carta cartaAtual = new Carta(Naipe, Valor, numCarta);
        Mao(cartaAtual);
    }

    public void setDerrota() {
        Derrotas++;
    }

    public int getDerrota() {
        return Derrotas;
    }

    public void setVitoria() {
        Vitorias++;
    }

    public int getVitorias() {
        return Vitorias;
    }
    
    public boolean inteligenciaArtificial(int valor) {
        boolean Continuar = false;
        if(valor < 10)
        {
           Continuar = true;
        }
        return Continuar;
    }
    
}
