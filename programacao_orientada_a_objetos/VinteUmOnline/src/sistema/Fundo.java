package sistema;

import VinteUmOnline.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javafx.application.Application;

/**
 *
 * @author Otávio
 */
public class Fundo extends javax.swing.JPanel {

    public int posicaoMesa = 0;
    Offline O = new Offline();

    Mesa M = O.M1;
    Baralho Baralho = O.Baralho;

    public Fundo() {
        initComponents();
        GerarMesa();
    }

    public void GerarMesa() {

        jButton3.setEnabled(false);
        O.Iniciar(Sessao.getInstance().getID());
        jLabel25.setText("Jogando");
        int jogadoresSentados = M.jogadorSentado.size() - 1;
        for (int i = 0; i <= jogadoresSentados; i++) {
            switch (i) {
                case 0:
                    jLabel1.setText(M.jogadorSentado.get(i).Nome);
                    break;
                case 1:
                    jLabel2.setText(M.jogadorSentado.get(i).Nome);
                    break;
                case 2:
                    jLabel3.setText(M.jogadorSentado.get(i).Nome);
                    break;
                case 3:
                    jLabel4.setText(M.jogadorSentado.get(i).Nome);
                    break;
                case 4:
                    jLabel5.setText(M.jogadorSentado.get(i).Nome);
                    break;
                case 5:
                    jLabel6.setText(M.jogadorSentado.get(i).Nome);
                    break;

            }
        }
        for (int n = 0; n <= jogadoresSentados; n++) {
            switch (n) {
                case 1:
                    jLabel7.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 2:
                    jLabel8.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 3:
                    jLabel9.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 4:
                    jLabel10.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 5:
                    jLabel11.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
            }
        }

        for (int n = 0; n <= jogadoresSentados; n++) {
            String C = "";
            if (M.jogadorSentado.get(n).fim == true) {
                C = "Parou";
            } else {
                C = "Jogando";
            }
            switch (n) {
                case 1:
                    jLabel12.setText(C);
                    break;
                case 2:
                    jLabel13.setText(C);
                    break;
                case 3:
                    jLabel14.setText(C);
                    break;
                case 4:
                    jLabel15.setText(C);
                    break;
                case 5:
                    jLabel16.setText(C);
                    break;
            }
        }

        maoJogador(M);

    }

    public static int IDUa;

    public int getIDU() {
        return IDUa;
    }

    public void JogandoParar(Mesa M, Baralho B) {
        jLabel25.setText("Parou");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);
        Jogo Jogo = new Jogo();
        while (Jogo.verificaFim(M) == false) {
            for (int i = 1; i < M.jogadorSentado.size(); i++) {

                boolean maquinaContinua = M.jogadorSentado.get(i).inteligenciaArtificial(Jogo.Contagem(M, i));

                if (maquinaContinua == true) {
                    M.jogadorSentado.get(i).Continuar(B);
                } else {
                    M.jogadorSentado.get(i).Parar();
                }

                String C = "";
                if (M.jogadorSentado.get(i).fim == true) {
                    C = "Parou";
                } else {
                    C = "Jogando";
                }
                switch (i) {
                    case 1:
                        jLabel12.setText(C);
                        break;
                    case 2:
                        jLabel13.setText(C);
                        break;
                    case 3:
                        jLabel14.setText(C);
                        break;
                    case 4:
                        jLabel15.setText(C);
                        break;
                    case 5:
                        jLabel16.setText(C);
                        break;

                }
            }
        }

    }

    public void Jogando(Mesa M, Baralho B) {

        Jogo Jogo = new Jogo();
        if (Jogo.verificaFim(M) == false) {
            for (int i = 0; i < M.jogadorSentado.size(); i++) {

                boolean maquinaContinua = M.jogadorSentado.get(i).inteligenciaArtificial(Jogo.Contagem(M, i));

                if (maquinaContinua == true) {
                    M.jogadorSentado.get(i).Continuar(B);
                } else {
                    M.jogadorSentado.get(i).Parar();
                }

                String C = "";
                if (M.jogadorSentado.get(i).fim == true) {
                    C = "Parou";
                } else {
                    C = "Jogando";
                }
                switch (i) {
                    case 1:
                        jLabel12.setText(C);
                        break;
                    case 2:
                        jLabel13.setText(C);
                        break;
                    case 3:
                        jLabel14.setText(C);
                        break;
                    case 4:
                        jLabel15.setText(C);
                        break;
                    case 5:
                        jLabel16.setText(C);
                        break;

                }
            }
        }

    }

    public void maoJogador(Mesa M) {

        int nIMG = M.jogadorSentado.get(0).maoJogador.size();
        int jogadoresSentados = M.jogadorSentado.size() - 1;
Jogo J = new Jogo();
        for (int i = 0; i < nIMG; i++) {
            String IMGn = String.valueOf(M.jogadorSentado.get(0).maoJogador.get(i).numCarta);
            String Naipe = String.valueOf(M.jogadorSentado.get(0).maoJogador.get(i).Naipe);
            int naIMG = J.conversorContagem(M.jogadorSentado.get(0).maoJogador.get(i).numCarta);
            String txtIMG = naIMG + " " ;
            String IMG = "Imagens/" + Naipe + IMGn + ".png";          
            switch (i) {
                case 0:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel19.setText(txtIMG);

                    break;
                case 1:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel20.setText(txtIMG);

                    break;
                case 2:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel21.setText(txtIMG);
                    break;
                case 3:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel22.setText(txtIMG);

                    break;
                case 4:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel23.setText(txtIMG);

                    break;
                case 5:
                    if (getClass().getResource(String.valueOf(IMG)) != null) {
                        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource(String.valueOf(IMG))));
                    }
                    jLabel24.setText(txtIMG);

                    break;
            }
        }

        for (int n = 0; n <= jogadoresSentados; n++) {
            switch (n) {
                case 1:
                    jLabel7.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 2:
                    jLabel8.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 3:
                    jLabel9.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 4:
                    jLabel10.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
                case 5:
                    jLabel11.setText("Cartas na mão: " + M.jogadorSentado.get(n).maoJogador.size());
                    break;
            }
        }

    }

    public int botao() {
        int i = 0;
        if (jButton1.getModel().isPressed()) {
            i = 1;
        }
        if (jButton2.getModel().isPressed()) {
            i = 2;
        }

        return i;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setText("Continuar");
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Parar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("J1");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("J2");
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("J3");
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("J4");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("J5");
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("J6");
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("JC2");
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("JC3");
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("JC4");
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("JC5");
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JC6");
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 153, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("C2");
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("C3");
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("C4");
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("C5");
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 153, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("C6");
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/Mesa.png"))); // NOI18N
        jLabel17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/LogoP.png"))); // NOI18N
        jLabel18.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/Imagens/1.png"))); // NOI18N
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("J1");
        jLabel25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(133, 133, 133)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        jButton3.getAccessibleContext().setAccessibleName("Voltar");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        M.jogadorSentado.get(0).Continuar(Baralho);
        Jogando(M, Baralho);
        maoJogador(M);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        M.jogadorSentado.get(0).Parar();
        JogandoParar(M, Baralho);
        maoJogador(M);
        Formatter x;
        Jogo J = new Jogo();
        jLabel7.setText(Jogo.exibirMao(M, 1));
        jLabel8.setText(Jogo.exibirMao(M, 2));
        jLabel9.setText(Jogo.exibirMao(M, 3));
        jLabel10.setText(Jogo.exibirMao(M, 4));
        jLabel11.setText(Jogo.exibirMao(M, 5));
        int resultados[] = Jogo.verificaVencedor(M);

        for (int i = 0; i <= M.jogadorSentado.size(); i++) {
            String C = "";
            if (resultados[i] == 2) {
                if(J.Contagem(M, 0) <= 21)
                {
                C = "Derrotado";
                }
                else
                {
                     C = " ";
                }
            } else {
                 if(J.Contagem(M, 0) <= 21)
                {
                C = "Vencedor";
                }
                 else{
                     C = " ";
                 }
            }
            switch (i) {
                case 0:
                    DAO dao = new DAO();
                     if(J.Contagem(M, 0) <= 21)
                {
                    dao.insereRodada(M.jogadorSentado.get(0).ID, resultados[i]);
                     jLabel25.setText(C);
                }
                else
                     {
                          dao.insereRodada(M.jogadorSentado.get(0).ID, 2);
                     jLabel25.setText("Estorou");
                     }
                case 1:
                    jLabel12.setText(C);
                    break;
                case 2:
                    jLabel13.setText(C);
                    break;
                case 3:
                    jLabel14.setText(C);
                    break;
                case 4:
                    jLabel15.setText(C);
                    break;
                case 5:
                    jLabel16.setText(C);
                    break;

            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Painel().setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
