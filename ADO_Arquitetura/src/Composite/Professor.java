package Composite;

import Strategy.CalculoMedia;
import Strategy.MediaSimples;

public class Professor {
    private String nome;
    private String materia;
    private CalculoMedia estrategia;

    public Professor(String nome, String materia) {
        this(nome, materia, new MediaSimples());
    }

    public Professor(String nome, String materia, CalculoMedia estrategia) {
        this.nome = nome;
        this.materia = materia;
        this.estrategia = estrategia;
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }

    public CalculoMedia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(CalculoMedia estrategia) {
        this.estrategia = estrategia;
    }
}
