package Composite;

/*
* Padrão de Projeto Composite:
* Compõe objetos em estruturas de árvore para representar hierarquias.
* O padrão Composite permite que os alunos sejam tratados de forma uniforme, quer sejam individuais ou grupos.
 */

public class AlunoComponente implements ComponenteEscola {
    private String nome;
    private String id;

    public AlunoComponente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + nome + ", ID: " + id);
    }
}
