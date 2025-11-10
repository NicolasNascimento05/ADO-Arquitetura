import Composite.Turma;
import Singleton.Escola;
import Composite.Aluno;
import Strategy.MediaSimples;
import Strategy.MediaPonderada;
import Strategy.CalculoMedia;

public class Main {
    public static void main(String[] args) {
        // Aqui entra o uso do Singleton, onde a instância única da escola para gerenciar as turmas.
        Escola escola1 = Escola.getInstancia();

        // Composite: Turma é um composto que pode conter Aluno (folha) ou outras Turmas.
        Turma turmaA = new Turma("Turma A");
        Aluno alunoA = new Aluno("Aluno A", "001", new double[]{8.5, 7.0, 9.0});
        Aluno alunoB = new Aluno("Aluno B", "002", new double[]{6.0, 6.0, 6.5});
        turmaA.adicionar(alunoA);
        turmaA.adicionar(alunoB);

        Turma turmaB = new Turma("Turma B");
        Aluno alunoC = new Aluno("Aluno C", "003", new double[]{9.0, 8.5, 7.5});
        Aluno alunoD = new Aluno("Aluno D", "004", new double[]{4.0, 5.5, 6.0});
        turmaB.adicionar(alunoC);
        turmaB.adicionar(alunoD);

        escola1.adicionarTurma(turmaA);
        escola1.adicionarTurma(turmaB);

        // Strategy: escolho a estratégia de cálculo de média que quero usar.
        CalculoMedia mediaSimples = new MediaSimples();
        CalculoMedia mediaPonderada = new MediaPonderada();

        // Uso do Composite + Strategy: peço para a turma exibir os aprovados usando a estratégia escolhida.
        System.out.println("\nAlunos aprovados (Média Simples) - Turma A:");
        turmaA.exibirAprovados(mediaSimples);

        System.out.println("\nAlunos aprovados (Média Ponderada) - Turma B:");
        turmaB.exibirAprovados(mediaPonderada);
    }
}
