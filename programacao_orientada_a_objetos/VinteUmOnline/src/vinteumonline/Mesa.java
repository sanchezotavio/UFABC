package VinteUmOnline;

import java.util.ArrayList;

public class Mesa {
    
    public ArrayList<Jogador> jogadorSentado = new ArrayList();
    public int posicao = 0;
    
    public void Sentados(Jogador J){
        jogadorSentado.add(J);
    }
   
    public int Proximo(){
        
        int n = jogadorSentado.size() - 1;
                
        if(posicao == n)
        {
            posicao = 0;
            return n;
        }
        else if(posicao < n){
            posicao++;
            return posicao;
        }
        else{
            return 0;
        }
       
    }
    
}