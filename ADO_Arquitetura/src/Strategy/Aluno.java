// src/Strategy/Aluno.java
package Strategy;

// Classe Aluno que utiliza a estratégia de cálculo de média
public class Aluno {
    private String nome;
    private String id;
    private double[] notas;
    private CalculoMedia calculoMedia;

    public Aluno(String nome, String id, double[] notas, CalculoMedia calculoMedia) {
        this.nome = nome;
        this.id = id;
        this.notas = notas;
        this.calculoMedia = calculoMedia;
    }

    public double getMedia() {
        return calculoMedia.calular(notas);
    }

    public void setCalculoMedia(CalculoMedia calculoMedia) {
        this.calculoMedia = calculoMedia;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
