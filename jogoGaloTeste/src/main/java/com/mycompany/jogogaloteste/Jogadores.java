/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogogaloteste;

import java.io.*;

/**
 *
 * @author goncalo farias
 */
public class Jogadores implements Serializable {
    private String nome;
    private int vitorias;
    private int derrotas;

    public Jogadores(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.derrotas = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addVitoria()
    {
        this.vitorias++;
    }
    
    public void resetVitorias()
    {
        this.vitorias = 0;
    }
    
    public int getNumVitorias()
    {
        return this.vitorias;
    }
}
