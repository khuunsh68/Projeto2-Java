/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jogogaloteste;

//import java.awt.Color;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author goncalo farias
 * @author ivo silva
 * @date 2021/06/13
 */
public class JogoGaloTabuleiro extends javax.swing.JFrame {

    private JFrame frameMsg;

    private String nome1;
    private String nome2;
    
    private final Jogadores jogadorX;
    private final Jogadores jogadorO;

    private String jogadorAtual;
    private int numJogos = 1;
    private int numEmpates = 0;
    private int numJogadas = 0;

    /**
     * Creates new form JogoGaloTabuleiro
     *
     * @param nome1 Nome do jogador X
     * @param nome2 Nome do jogador O
     * @param primeiroJogador Nome do primeiro Jogador a jogar
     */
    public JogoGaloTabuleiro(String nome1, String nome2, String primeiroJogador) {
        initComponents();
        this.jogadorX = new Jogadores(nome1);
        this.jogadorO = new Jogadores(nome2);
        this.jogadorAtual = primeiroJogador;
        setVisible(true); // Este setVisible serve para mostrar a informaçao de jogador a jogar só depois do form aberto
        actualizarEstatisticas();
        msgJogadorActual(); // Print do jogador a jogar no form em si
        mostrarJogadorAtual(); // Alerta com vez de quem vai jogar primeiro

    }

    /**
     * Actualiza label que diz quem de quem é a próxima jogada
     */
    private void msgJogadorActual()
    {
        jLabelJogActual.setText("Vez do jogador " + jogadorAtual);
    }
   
     /**
     * Alternar entre jogadores
     */
    private void escolheJogador() {
        if (jogadorAtual.equalsIgnoreCase("x")) {
            jogadorAtual = "O";
        } else {
            jogadorAtual = "X";
        }
        
        msgJogadorActual();
    }

    /**
     * Faz reset ao tabuleiro
     */
    private void resetTabuleiro() {
        jBtn1.setText("");
        jBtn1.setEnabled(true);
        jBtn1.setBackground(null);

        jBtn2.setText("");
        jBtn2.setEnabled(true);
        jBtn2.setBackground(null);

        jBtn3.setText("");
        jBtn3.setEnabled(true);
        jBtn3.setBackground(null);

        jBtn4.setText("");
        jBtn4.setEnabled(true);
        jBtn4.setBackground(null);

        jBtn5.setText("");
        jBtn5.setEnabled(true);
        jBtn5.setBackground(null);

        jBtn6.setText("");
        jBtn6.setEnabled(true);
        jBtn6.setBackground(null);

        jBtn7.setText("");
        jBtn7.setEnabled(true);
        jBtn7.setBackground(null);

        jBtn8.setText("");
        jBtn8.setEnabled(true);
        jBtn8.setBackground(null);

        jBtn9.setText("");
        jBtn9.setEnabled(true);
        jBtn9.setBackground(null);

        numJogadas = 0;
        numJogos++;
    }

    /**
     * Muda a cor de fundo dos botões vencedores
     */
    private void mudaBgVencedor(JButton btn1, JButton btn2, JButton btn3) {
        btn1.setBackground(new Color(153, 255, 153));
        btn2.setBackground(new Color(153, 255, 153));
        btn3.setBackground(new Color(153, 255, 153));
    }

    /**
     * Actualiza as estatisticas dos jogadores
     */
    private void actualizarEstatisticas() {
        double percJogX = 0.0;
        double percJogO = 0.0;
        double percEmp = 0.0;
        
        if (numJogos != 0) {
            percJogX = (jogadorX.getNumVitorias() * 100) / numJogos;
            percJogO = (jogadorO.getNumVitorias() * 100) / numJogos;
            percEmp = (numEmpates * 100) / numJogos;
        }
        
        jLabelNomeJogX.setText(jogadorX.getNome() + ": " + jogadorX.getNumVitorias() + String.format(" ( %.2f%% )", percJogX));
        jLabelNomeJogO.setText(jogadorO.getNome() + ": " + jogadorO.getNumVitorias() + String.format(" ( %.2f%% )", percJogO));
        jNumJogos.setText(String.valueOf(numJogos));
        jNumEmpates.setText(numEmpates + String.format(" ( %.2f%% )", percEmp));
    }

    /**
     * Verifica se houve um vencedor na jogada
     */
    private void verificaJogada() {
        String b1 = jBtn1.getText();
        String b2 = jBtn2.getText();
        String b3 = jBtn3.getText();
        String b4 = jBtn4.getText();
        String b5 = jBtn5.getText();
        String b6 = jBtn6.getText();
        String b7 = jBtn7.getText();
        String b8 = jBtn8.getText();
        String b9 = jBtn9.getText();

        //Color btnBorder = new Color(102,255,102);
        //Color btnBg = new Color(153,255,153);
        // = true;
        /**
         * Se não houver mais jogadas disponiveis, o jogo acaba em empate
         */

        if (!b1.isEmpty()) {
            if (b1.equals(b2) && b2.equals(b3)) {
                mudaBgVencedor(jBtn1, jBtn2, jBtn3);
                JOptionPane.showMessageDialog(this, "Jogador " + b1 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b1.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }

            if (b1.equals(b5) && b5.equals(b9)) {
                mudaBgVencedor(jBtn1, jBtn5, jBtn9);
                JOptionPane.showMessageDialog(this, "Jogador " + b1 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b1.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }

            if (b1.equals(b4) && b4.equals(b7)) {
                mudaBgVencedor(jBtn1, jBtn4, jBtn7);
                JOptionPane.showMessageDialog(this, "Jogador " + b1 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b1.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }
        }

        if (!b5.isEmpty()) {
            if (b5.equals(b4) && b5.equals(b6)) {
                mudaBgVencedor(jBtn4, jBtn5, jBtn6);

                JOptionPane.showMessageDialog(this, "Jogador " + b4 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);

                (b5.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }

            if (b5.equals(b2) && b5.equals(b8)) {
                mudaBgVencedor(jBtn2, jBtn5, jBtn8);
                JOptionPane.showMessageDialog(this, "Jogador " + b2 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b5.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }

            if (b5.equals(b3) && b5.equals(b7)) {
                mudaBgVencedor(jBtn3, jBtn5, jBtn7);
                JOptionPane.showMessageDialog(this, "Jogador " + b3 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b5.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }
        }

        if (!b7.isEmpty()) {
            if (b7.equals(b8) && b8.equals(b9)) {
                mudaBgVencedor(jBtn7, jBtn8, jBtn9);
                JOptionPane.showMessageDialog(this, "Jogador " + b7 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b7.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }
        }

        if (!b3.isEmpty()) {
            if (b3.equals(b6) && b6.equals(b9)) {
                mudaBgVencedor(jBtn3, jBtn6, jBtn9);
                JOptionPane.showMessageDialog(this, "Jogador " + b3 + " Ganhou!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
                (b3.equalsIgnoreCase("X") ? jogadorX : jogadorO).addVitoria();
                actualizarEstatisticas();
                resetTabuleiro();
                return;
            }
        }

        if (numJogadas >= 9) {
            JOptionPane.showMessageDialog(this, "Jogadores Empataram!", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
            numEmpates++;
            actualizarEstatisticas();
            resetTabuleiro();
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JContainerTabuleiro = new javax.swing.JPanel();
        jBtn3 = new javax.swing.JButton();
        jBtn1 = new javax.swing.JButton();
        jBtn2 = new javax.swing.JButton();
        jBtn4 = new javax.swing.JButton();
        jBtn5 = new javax.swing.JButton();
        jBtn6 = new javax.swing.JButton();
        jBtn9 = new javax.swing.JButton();
        jBtn8 = new javax.swing.JButton();
        jBtn7 = new javax.swing.JButton();
        jContainerEstatisticas = new javax.swing.JPanel();
        jLabelNumJogos = new javax.swing.JLabel();
        jNumJogos = new javax.swing.JLabel();
        jNumEmpates = new javax.swing.JLabel();
        jLabelNumEmp = new javax.swing.JLabel();
        jLabelNomeJogX = new javax.swing.JLabel();
        jLabelNomeJogO = new javax.swing.JLabel();
        jContainerTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelJogActual = new javax.swing.JLabel();
        jContainerMenu = new javax.swing.JPanel();
        jBtnSair = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JContainerTabuleiro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtn3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn3ActionPerformed(evt);
            }
        });

        jBtn1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn1ActionPerformed(evt);
            }
        });

        jBtn2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn2.setActionCommand("jButton2");
        jBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn2ActionPerformed(evt);
            }
        });

        jBtn4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn4ActionPerformed(evt);
            }
        });

        jBtn5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn5ActionPerformed(evt);
            }
        });

        jBtn6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn6ActionPerformed(evt);
            }
        });

        jBtn9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn9ActionPerformed(evt);
            }
        });

        jBtn8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn8ActionPerformed(evt);
            }
        });

        jBtn7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn7ActionPerformed(evt);
            }
        });

        jLabelNumJogos.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabelNumJogos.setText("Número de Jogos:");

        jNumJogos.setText("jNumJogos");

        jNumEmpates.setText("jLabelNumEMpates");

        jLabelNumEmp.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabelNumEmp.setText("Empates:");

        jLabelNomeJogX.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabelNomeJogX.setText("Jogador 2: " + nome2);

        jLabelNomeJogO.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabelNomeJogO.setText("Jogador 1: " + nome1);

        javax.swing.GroupLayout jContainerEstatisticasLayout = new javax.swing.GroupLayout(jContainerEstatisticas);
        jContainerEstatisticas.setLayout(jContainerEstatisticasLayout);
        jContainerEstatisticasLayout.setHorizontalGroup(
            jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerEstatisticasLayout.createSequentialGroup()
                .addGroup(jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNomeJogO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomeJogX, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jContainerEstatisticasLayout.createSequentialGroup()
                        .addComponent(jLabelNumJogos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumJogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jContainerEstatisticasLayout.createSequentialGroup()
                        .addComponent(jLabelNumEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jNumEmpates, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jContainerEstatisticasLayout.setVerticalGroup(
            jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeJogO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNumJogos)
                        .addComponent(jNumJogos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jContainerEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeJogX)
                    .addComponent(jLabelNumEmp)
                    .addComponent(jNumEmpates))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JContainerTabuleiroLayout = new javax.swing.GroupLayout(JContainerTabuleiro);
        JContainerTabuleiro.setLayout(JContainerTabuleiroLayout);
        JContainerTabuleiroLayout.setHorizontalGroup(
            JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                        .addComponent(jBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                        .addComponent(jBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                        .addComponent(jBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jContainerEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        JContainerTabuleiroLayout.setVerticalGroup(
            JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JContainerTabuleiroLayout.createSequentialGroup()
                        .addGroup(JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JContainerTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jContainerEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainerTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabelTitulo.setText("Jogo do Galo");

        jLabelJogActual.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jContainerTituloLayout = new javax.swing.GroupLayout(jContainerTitulo);
        jContainerTitulo.setLayout(jContainerTituloLayout);
        jContainerTituloLayout.setHorizontalGroup(
            jContainerTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerTituloLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainerTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelJogActual, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jContainerTituloLayout.setVerticalGroup(
            jContainerTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerTituloLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJogActual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainerMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jContainerMenuLayout = new javax.swing.GroupLayout(jContainerMenu);
        jContainerMenu.setLayout(jContainerMenuLayout);
        jContainerMenuLayout.setHorizontalGroup(
            jContainerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jContainerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
        );
        jContainerMenuLayout.setVerticalGroup(
            jContainerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JContainerTabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jContainerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jContainerTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jContainerTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jContainerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JContainerTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarJogadorAtual() {
        JOptionPane.showMessageDialog(this, "Vez do jogador " + jogadorAtual + " jogar", "Jogo do Galo", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void jBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn1ActionPerformed
        jBtn1.setText(jogadorAtual);
        jBtn1.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn1ActionPerformed

    private void jBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn9ActionPerformed
        jBtn9.setText(jogadorAtual);
        jBtn9.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn9ActionPerformed

    private void jBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn2ActionPerformed
        jBtn2.setText(jogadorAtual);
        jBtn2.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn2ActionPerformed

    private void jBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn4ActionPerformed
        jBtn4.setText(jogadorAtual);
        jBtn4.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn4ActionPerformed

    private void jBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn5ActionPerformed
        jBtn5.setText(jogadorAtual);
        jBtn5.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn5ActionPerformed

    private void jBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn6ActionPerformed
        jBtn6.setText(jogadorAtual);
        jBtn6.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn6ActionPerformed

    private void jBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn7ActionPerformed
        jBtn7.setText(jogadorAtual);
        jBtn7.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn7ActionPerformed

    private void jBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn8ActionPerformed
        jBtn8.setText(jogadorAtual);
        jBtn8.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn8ActionPerformed

    private void jBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn3ActionPerformed
        jBtn3.setText(jogadorAtual);
        jBtn3.setEnabled(false);
        numJogadas++;

        escolheJogador();
        verificaJogada();
    }//GEN-LAST:event_jBtn3ActionPerformed

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        frameMsg = new JFrame("Sair");
        if (JOptionPane.showConfirmDialog(frameMsg, "Quer mesmo sair do jogo ?", "Jogo do Galo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        frameMsg = new JFrame("Novo Jogo");
        if (JOptionPane.showConfirmDialog(frameMsg, "Quer mesmo criar novo jogo ?", "Jogo do Galo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            numEmpates = 0;
            numJogos = 0;
            jogadorX.resetVitorias();
            jogadorO.resetVitorias();
            actualizarEstatisticas();
            resetTabuleiro();
        }
    }//GEN-LAST:event_jBtnNovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoGaloTabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoGaloTabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoGaloTabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoGaloTabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoGaloTabuleiro("", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JContainerTabuleiro;
    private javax.swing.JButton jBtn1;
    private javax.swing.JButton jBtn2;
    private javax.swing.JButton jBtn3;
    private javax.swing.JButton jBtn4;
    private javax.swing.JButton jBtn5;
    private javax.swing.JButton jBtn6;
    private javax.swing.JButton jBtn7;
    private javax.swing.JButton jBtn8;
    private javax.swing.JButton jBtn9;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JPanel jContainerEstatisticas;
    private javax.swing.JPanel jContainerMenu;
    private javax.swing.JPanel jContainerTitulo;
    private javax.swing.JLabel jLabelJogActual;
    private javax.swing.JLabel jLabelNomeJogO;
    private javax.swing.JLabel jLabelNomeJogX;
    private javax.swing.JLabel jLabelNumEmp;
    private javax.swing.JLabel jLabelNumJogos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jNumEmpates;
    private javax.swing.JLabel jNumJogos;
    // End of variables declaration//GEN-END:variables
}
