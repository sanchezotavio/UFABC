package VinteUmOnline;

import java.util.ArrayList;

public class Jogo {

    public void acessoJogadores(Mesa M, String Nome, int ID, int posicaoMesa) {
        M.Sentados(new Jogador(Nome, ID, posicaoMesa));
    }

    public void acessoMaquinas(Mesa M, int posicoes) {
        int ID = 1;
        int posicaoMesa = 1;
        String Nome;
        Visual Visual = new Visual();
        ArrayList<String> Nomes = Visual.Nomes();

        for (int i = 0; i < posicoes; i++) {
            Nome = Nomes.get(i);
            M.Sentados(new Jogador(Nome, ID, posicaoMesa));
            ID++;
            posicaoMesa++;
        }

    }

    public int conversorContagem(int i) {

        int valor = 0;
        switch (i) {
            case 0:
                valor = 1;
                break;
            case 1:
                valor = 2;
                break;
            case 2:
                valor = 3;
                break;
            case 3:
                valor = 4;
                break;
            case 4:
                valor = 5;
                break;
            case 5:
                valor = 6;
                break;
            case 6:
                valor = 7;
                break;
            case 7:
                valor = 8;
                break;
            case 8:
                valor = 9;
                break;
            case 9:
                valor = 10;
                break;
            case 10:
                valor = 10;
                break;
            case 11:
                valor = 10;
                break;
            case 12:
                valor = 10;
                break;
        }

        return valor;
    }

    public static boolean verificaFim(Mesa M) {

        boolean checado = false;

        for (int i = 0; i < M.jogadorSentado.size(); i++) {
            if (M.jogadorSentado.get(i).fim == true) {
                checado = true;
            } else {
                checado = false;
                break;
            }
        }

        return checado;
    }

    public static int[] verificaVencedor(Mesa M) {
        int jogadoresSentados = M.jogadorSentado.size() - 1;

        int vencedor = 0;
        ArrayList<Jogador> empatados = new ArrayList();
        int nEmpatados = 0;
        int jogadorI = 0;
        int jogadorE = 0;
        int resultados[] = new int[M.jogadorSentado.size()];
        Jogo Jogo = new Jogo();

        for (int i = 0; i <= jogadoresSentados; i++) {
            jogadorI = Jogo.Contagem(M, i);
            System.out.println(i + " " + jogadorI);
            if (jogadorI <= 21) {
                if (i + 1 <= jogadoresSentados) {
                    //*Laço todos*//
                    for (int e = 0; e <= jogadoresSentados; e++) {
                        jogadorE = Jogo.Contagem(M, e);
                        if (i != e) {
                            if (jogadorI == jogadorE && jogadorI == Jogo.Contagem(M, vencedor)) {
                                empatados.add(M.jogadorSentado.get(i));
                                empatados.add(M.jogadorSentado.get(e));
                            }
                            if (jogadorI > jogadorE && jogadorI > Jogo.Contagem(M, vencedor)) {
                                vencedor = i;
                            }
                            if (i == 4) {
                                if (jogadorI > Jogo.Contagem(M, vencedor)) {
                                    vencedor = 4;
                                }
                                
                                if (jogadorI == Jogo.Contagem(M, vencedor)) {
                                empatados.add(M.jogadorSentado.get(i));
                                empatados.add(M.jogadorSentado.get(vencedor));
                            }
                            }
                        }
                    }
                }
            }
        }

        if (nEmpatados > 0) {

            for (int i = 0; i <= jogadoresSentados; i++) {

                for (int e = 0; e <= jogadoresSentados; e++) {
                    if (i != e) {
                        if (Jogo.Contagem(M, empatados.get(i).posicaoMesa) < Jogo.Contagem(M, empatados.get(e).posicaoMesa)) {
                            empatados.remove(i);
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i <= jogadoresSentados; i++) {
                if (Jogo.Contagem(M, i) <= 21 && Jogo.Contagem(M, i) == Jogo.Contagem(M, empatados.get(0).posicaoMesa)) {
                    M.jogadorSentado.get(vencedor).setVitoria();
                    System.out.println("Jogador " + M.jogadorSentado.get(vencedor).Nome + " é o vencedor");
                    resultados[vencedor] = 1;
                } else {
                    M.jogadorSentado.get(i).setDerrota();
                    System.out.println("Jogador " + M.jogadorSentado.get(i).Nome + " foi derrotado");
                    resultados[vencedor] = 2;
                }

            }

        } else {
            jogadorI = 0;
            for (int i = 0; i <= jogadoresSentados; i++) {
                if (Jogo.Contagem(M, i) <= 21 && Jogo.Contagem(M, i) == Jogo.Contagem(M, vencedor)) {
                    M.jogadorSentado.get(vencedor).setVitoria();
                    System.out.println("Jogador " + M.jogadorSentado.get(i).Nome + " é o vencedor");
                    resultados[vencedor] = 1;
                } else {
                    M.jogadorSentado.get(i).setDerrota();
                    System.out.println("Jogador " + M.jogadorSentado.get(i).Nome + " foi derrotado");
                    resultados[i] = 2;
                }

            }
        }

        return resultados;
    }

    public int Contagem(Mesa M, int Jogador) {

        int total = 0;
        int nMao = M.jogadorSentado.get(Jogador).maoJogador.size();

        for (int i = 0; i < nMao; i++) {
            total = total + conversorContagem(M.jogadorSentado.get(Jogador).maoJogador.get(i).numCarta);
        }

        return total;
    }

    public static String exibirMao(Mesa M, int Jogador) {
        Visual V = new Visual();
        String Mao = "";
        for (int i = 0; i < M.jogadorSentado.get(Jogador).maoJogador.size(); i++) {
            Mao += V.texto(M.jogadorSentado.get(Jogador).maoJogador.get(i).Naipe, M.jogadorSentado.get(Jogador).maoJogador.get(i).numCarta) + "<br />";
        }

        String HTML = "<html><body>" + Mao + "</body></html>";
        return HTML;
    }
}
