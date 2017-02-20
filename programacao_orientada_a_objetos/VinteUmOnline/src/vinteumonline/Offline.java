package VinteUmOnline;

import java.util.Scanner;
import sistema.DAO;

public class Offline extends Partida {

    Scanner txt = new Scanner(System.in);

    public Baralho Baralho = new Baralho();
    public Mesa M1 = new Mesa();
    public Jogo Jogo = new Jogo();
    public int ID = 0;
    public int posicaoMesa = 0;

    public Mesa Iniciar(int IDU) {

        Baralho.gerarBaralho();

        DAO dao = new DAO();
        String Nome = dao.nomeJogador(IDU);

        Jogo.acessoJogadores(M1, Nome, IDU, 0);

        int nJogadores = 5;

        Jogo.acessoMaquinas(M1, nJogadores);

        Baralho.embaralhar();

        for (int i = 0; i < M1.jogadorSentado.size(); i++) {
            M1.jogadorSentado.get(i).Iniciar(Baralho);;
        }

        return M1;
    }

    public void Jogando(Mesa M, Baralho B) {
       
    }
}
