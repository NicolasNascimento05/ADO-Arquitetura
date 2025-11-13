package Composite;

// Classe Aluno faz parte do padrão Composite, representando um componente folha na estrutura.
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
        this.notas = (notas != null) ? notas.clone() : null;
    }

    public double[] getNotas() {
        return (notas != null) ? notas.clone() : null;
    }

    public void setNotas(double[] notas) {
        this.notas = (notas != null) ? notas.clone() : null;
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
