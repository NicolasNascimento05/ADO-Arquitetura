package Composite;
import Strategy.CalculoMedia;
import Strategy.MediaSimples;

import java.util.ArrayList;
import java.util.List;

//Classe turma deve armazenar uma coleção de componentes (Alunos e Professores)
public class Turma implements ComponenteEscola {
    private String nome;
    // Lista que contém Aluno ou Turma (composite)
    private List<ComponenteEscola> turmaForma = new ArrayList<>();
    private Professor professor;

    public Turma(String nome) {
        this.nome = nome;
    }

    // Adiciona componente na composição
    public void adicionar(ComponenteEscola componente){
        turmaForma.add(componente);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("Turma: " + nome + "%n");
        if (professor != null) {
            System.out.println("Professores: " + professor.getNome() + " - " + professor.getMateria());
        } else {
            System.out.println("Professores: Nenhum professor atribuído");
        }
        // Itera pelos componentes: graças ao Composite, tratamento uniforme
        for(ComponenteEscola componente : turmaForma){
            componente.exibirInformacoes();
        }
    }

    // Mantém versão compatível que recebe a estratégia explicitamente
    public void aprovados(CalculoMedia calculo) {
        System.out.println("Alunos aprovados da turma: " + nome);
        for (ComponenteEscola componente : turmaForma) {
            // Uso de instanceof para distinguir folhas (Aluno) de nós compostos (Turma)
            if (componente instanceof Aluno) {
                Aluno aluno = (Aluno) componente;
                double[] notas = aluno.getNotas();
                if (notas == null || notas.length == 0) continue;
                double media = calculo.calular(notas);
                if (media >= 6.0) {
                    System.out.printf("Aluno: %s, ID: %s, Média: %.2f%n", aluno.getNome(), aluno.getId(), media);
                }
            } else if (componente instanceof Turma) {
                // Recursão para suportar sub-turmas
                ((Turma) componente).aprovados(calculo);
            }
        }
    }

    // Usa a estratégia definida pelo professor da turma (ou MediaSimples por padrão)
    public void exibirAprovados() {
        CalculoMedia calculo = (professor != null && professor.getEstrategia() != null)
                ? professor.getEstrategia()
                : new MediaSimples(); // fallback
        aprovados(calculo);
    }
}
