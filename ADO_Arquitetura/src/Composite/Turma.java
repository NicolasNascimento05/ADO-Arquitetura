// src/Composite/Turma.java
package Composite;

import Strategy.CalculoMedia;

import java.util.ArrayList;
import java.util.List;

// Componente composto que pode conter outros componentes.
public class Turma implements ComponenteEscola {
    private String nome;
    private List<ComponenteEscola> turmaForma = new ArrayList<>();

    public Turma(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteEscola componente){
        turmaForma.add(componente);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("Turma: " + nome + "\n");
        for(ComponenteEscola componente : turmaForma){
            componente.exibirInformacoes();
        }
    }

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
}
