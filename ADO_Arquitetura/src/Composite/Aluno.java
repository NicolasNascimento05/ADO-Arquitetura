// java
// src/Composite/Aluno.java
package Composite;

public class Aluno implements ComponenteEscola {
    private String nome;
    private String id;
    private double[] notas;

    public Aluno(String nome, String id) {
        this(nome, id, null);
    }

    public Aluno(String nome, String id, double[] notas) {
        this.nome = nome;
        this.id = id;
        this.notas = notas;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + nome + ", ID: " + id);
    }
}
