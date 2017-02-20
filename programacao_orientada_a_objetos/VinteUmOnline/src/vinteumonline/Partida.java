package VinteUmOnline;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Partida {
    
    public Baralho B = new Baralho();
   
    
    public abstract Mesa Iniciar(int IDU);
    public abstract void Jogando(Mesa M , Baralho B);
    
    public void novaRodada()
    {        
        B.embaralhar(); 
    }
    
}
