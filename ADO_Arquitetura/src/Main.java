import Composite.Turma;
import Singleton.Escola;
import Composite.Aluno;
import Composite.Professor;
import Strategy.MediaSimples;
import Strategy.MediaPonderada;

public class Main {
    public static void main(String[] args) {
        Escola escola1 = Escola.getInstancia();

        Turma turmaA = new Turma("Turma A");
        Aluno alunoA1 = new Aluno("Caio", "001", new double[]{8.5, 7.0, 9.0});
        Aluno alunoA2 = new Aluno("Fernanda", "002", new double[]{6.0, 6.0, 6.5});
        Aluno alunoA3 = new Aluno("Rodrigo", "003", new double[]{1.0, 8.0, 5.5});
        turmaA.adicionar(alunoA1);
        turmaA.adicionar(alunoA2);
        turmaA.adicionar(alunoA3);

        Turma turmaB = new Turma("Turma B");
        Aluno turmaB1 = new Aluno("Bruno", "011", new double[]{9.0, 8.5, 7.5});
        Aluno turmaB2 = new Aluno("Bianca", "012", new double[]{4.0, 5.5, 6.0});
        Aluno turmaB3 = new Aluno("Jessica", "013", new double[]{10.0, 7.5, 6.0});
        turmaB.adicionar(turmaB1);
        turmaB.adicionar(turmaB2);
        turmaB.adicionar(turmaB3);

        // Professor define o metodo de correção
        Professor profA = new Professor("Prof. Ana", "Matemática", new MediaSimples());
        // Bruno usa média ponderada com pesos personalizados (ex.: prova1=1, prova2=2, prova3=3)
        Professor profB = new Professor("Prof. Bruno", "História", new MediaPonderada(new double[]{1.0, 2.0, 3.0}));
        turmaA.setProfessor(profA);
        turmaB.setProfessor(profB);

        escola1.adicionarTurma(turmaA);
        escola1.adicionarTurma(turmaB);

        Escola escola2 = Escola.getInstancia();

        Turma turmaC = new Turma("Turma C");
        Aluno alunoC1 = new Aluno("Mariana", "005", new double[]{7.0, 7.5, 8.0});
        Aluno alunoC2 = new Aluno("Lucas", "006", new double[]{5.0, 6.0, 6.5});
        Aluno alunoC3 = new Aluno("Thiago", "009", new double[]{6.0, 6.5, 7.0});
        turmaC.adicionar(alunoC1);
        turmaC.adicionar(alunoC2);
        turmaC.adicionar(alunoC3);

        Turma turmaD = new Turma("Turma D");
        Aluno turmaD1 = new Aluno("Eduardo", "007", new double[]{9.5, 8.0, 9.0});
        Aluno turmaD2 = new Aluno("Paola", "008", new double[]{3.5, 4.0, 5.0});
        Aluno turmaD3 = new Aluno("Sofia", "010", new double[]{6.5, 7.0, 6.0});
        turmaD.adicionar(turmaD1);
        turmaD.adicionar(turmaD2);
        turmaD.adicionar(turmaD3);

        // Carla usa média ponderada com pesos específicos
        Professor profC = new Professor("Prof. Carla", "Física", new MediaPonderada(new double[]{2.0, 1.0, 1.5}));
        Professor profD = new Professor("Prof. Diego", "Química", new MediaSimples());
        turmaC.setProfessor(profC);
        turmaD.setProfessor(profD);

        escola2.adicionarTurma(turmaC);
        escola2.adicionarTurma(turmaD);

        System.out.println("Turmas escola 1:");
        turmaA.exibirInformacoes();
        System.out.println("-----------------------\n");
        turmaB.exibirInformacoes();
        System.out.println("-----------------------\n");

        System.out.println("Turmas escola 2:");
        turmaC.exibirInformacoes();
        System.out.println("-----------------------\n");
        turmaD.exibirInformacoes();
        System.out.println("-----------------------\n");

        // Agora usa a estratégia definida pelo professor de cada turma
        System.out.println("\nAlunos aprovados - Turma A:");
        turmaA.exibirAprovados();

        System.out.println("\nAlunos aprovados - Turma B:");
        turmaB.exibirAprovados();

        System.out.println("\nAlunos aprovados - Turma C:");
        turmaC.exibirAprovados();

        System.out.println("\nAlunos aprovados - Turma D :");
        turmaD.exibirAprovados();
    }
}
