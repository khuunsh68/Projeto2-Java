/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogogaloteste;

import java.io.*;

/**
 *
 * @author goncalo farias
 * @author ivo silva
 * @date 2021/06/13
 */
public class Jogadores implements Serializable {
    private String nome;
    private int vitorias;

    /**
     * Construtor da classe Jogadores
     * @param nome Nome do jogador
     */
    public Jogadores(String nome) {
        this.nome = nome;
        this.vitorias = 0;
    }

    /**
     * Retorna o nome do jogador
     * @return Nome do jogador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Altera o nome do jogador
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona uma vitória ao jogador
     */
    public void addVitoria()
    {
        this.vitorias++;
    }

    /**
     * Faz reset ao número de vitórias do jogador
     */
    public void resetVitorias()
    {
        this.vitorias = 0;
    }

    /**
     * Retorna o número de vitórias do jogador
     * @return Número de vitórias do jogador
     */
    public int getNumVitorias()
    {
        return this.vitorias;
    }
}
