package VinteUmOnline;

import java.util.ArrayList;
import java.util.Collections;

public class Visual {

   
    
    public String texto(int Naipe, int Valor) {
        String cartaValor = "";
        String cartaNaipe = "";

        switch (Valor) {
            case 0:
                cartaValor = "A";
                break;
            case 1:
                cartaValor = "2";
                break;
            case 2:
                cartaValor = "3";
                break;
            case 3:
                cartaValor = "4";
                break;
            case 4:
                cartaValor = "5";
                break;
            case 5:
                cartaValor = "6";
                break;
            case 6:
                cartaValor = "7";
                break;
            case 7:
                cartaValor = "8";
                break;
            case 8:
                cartaValor = "9";
                break;
            case 9:
                cartaValor = "10";
                break;
            case 10:
                cartaValor = "J";
                break;
            case 11:
                cartaValor = "Q";
                break;
            case 12:
                cartaValor = "K";
                break;
            case 13:
                cartaValor = "Erro";
                break;
        }

        switch (Naipe) {
            case 0:
                cartaNaipe = "Espadas";
                break;
            case 1:
                cartaNaipe = "Paus";
                break;
            case 2:
                cartaNaipe = "Copas";
                break;
            case 3:
                cartaNaipe = "Ouros";
                break;
        }

        return cartaValor + " de " + cartaNaipe;

    }

    public ArrayList Nomes() {
        ArrayList<String> Nomes = new ArrayList();
        Nomes.add("Otávio");
        Nomes.add("Bruna");
        Nomes.add("Miguel");
        Nomes.add("Sophia");
        Nomes.add("Davi");
        Nomes.add("Alice");
        Nomes.add("Julia");
        Nomes.add("Pedro");
        Nomes.add("Gabriel");
        Nomes.add("Manuela");
        Nomes.add("Bernardo");
        Nomes.add("Laura");
        Nomes.add("Lucas");
        Nomes.add("Luiza");
        Nomes.add("Matheus");
        Nomes.add("Valentina");
        Nomes.add("Rafael");
        Nomes.add("Giovanna");
        Nomes.add("Heitor");
        Nomes.add("Maria Eduarda");
        Nomes.add("Enzo");
        Nomes.add("Helena");
        Nomes.add("Guilherme");
        Nomes.add("Beatriz");
        Nomes.add("Nicolas");
        Nomes.add("Maria Luiza");
        Nomes.add("Lorenzo");
        Nomes.add("Lara");
        Nomes.add("Gustavo");
        Nomes.add("Mariana");
        Nomes.add("Felipe");
        Nomes.add("Nicole");
        Nomes.add("Samuel");
        Nomes.add("Rafaela");
        Nomes.add("João Pedro");
        Nomes.add("Heloísa");
        Nomes.add("Daniel");
        Nomes.add("Isadora");
        Nomes.add("Vitor");
        Nomes.add("Lívia");
        Nomes.add("Leonardo");
        Nomes.add("Maria Clara");
        Nomes.add("Henrique");
        Nomes.add("Ana Clara");
        Nomes.add("Theo");
        Nomes.add("Lorena");
        Nomes.add("Murilo");
        Nomes.add("Gabriela");
        Nomes.add("Eduardo");
        Nomes.add("Yasmin");
        Nomes.add("Pedro Henrique");
        Collections.shuffle(Nomes);
        return Nomes;
        
    }
    
}
