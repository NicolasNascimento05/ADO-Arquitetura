// File: `src/Composite/Turma.java`
package Composite;
import Strategy.CalculoMedia;
import Strategy.MediaSimples;

import java.util.ArrayList;
import java.util.List;

public class Turma implements ComponenteEscola {
    private String nome;
    private List<ComponenteEscola> turmaForma = new ArrayList<>();
    private Professor professor;

    public Turma(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteEscola componente){
        turmaForma.add(componente);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void exibirProfessor() {
        if (professor != null) {
            System.out.println("Professor: " + professor.getNome() + ", Matéria: " + professor.getMateria());
        }
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("Turma: " + nome + "%n");
        if (professor != null) {
            System.out.println("Professores: " + professor.getNome() + " - " + professor.getMateria());
        } else {
            System.out.println("Professores: Nenhum professor atribuído");
        }
        for(ComponenteEscola componente : turmaForma){
            componente.exibirInformacoes();
        }
    }

    // Mantém versão compatível que recebe a estratégia explicitamente
    public void exibirAprovados(CalculoMedia calculo) {
        System.out.println("Alunos aprovados da turma: " + nome);
        for (ComponenteEscola componente : turmaForma) {
            if (componente instanceof Aluno) {
                Aluno aluno = (Aluno) componente;
                double[] notas = aluno.getNotas();
                if (notas == null || notas.length == 0) continue;
                double media = calculo.calular(notas);
                if (media >= 6.0) {
                    System.out.printf("Aluno: %s, ID: %s, Média: %.2f%n", aluno.getNome(), aluno.getId(), media);
                }
            } else if (componente instanceof Turma) {
                ((Turma) componente).exibirAprovados(calculo);
            }
        }
    }

    // Nova versão: usa a estratégia definida pelo professor da turma (ou MediaSimples por padrão)
    public void exibirAprovados() {
        CalculoMedia calculo = (professor != null && professor.getEstrategia() != null)
                ? professor.getEstrategia()
                : new MediaSimples();
        exibirAprovados(calculo);
    }
}
