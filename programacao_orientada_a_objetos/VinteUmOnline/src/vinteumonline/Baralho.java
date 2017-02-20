package VinteUmOnline;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

    public ArrayList<Carta> atrCarta = new ArrayList();
    public int ordem[] = new int[52];
    public static int ordemBaralho = 0;

    public void gerarBaralho() {
        int z = 0;
        for (int i = 0; i <= 3; i++) {
            for (int e = 0; e < 13; e++) {
                z++;
                atrCarta.add(new Carta(i, z, e));
            }
        }
    }

    public void embaralhar() {
        ordemBaralho = 0;
        Collections.shuffle(atrCarta);
    }

    public int proxima() {
        ordemBaralho++;
        return ordemBaralho;
    }
}
