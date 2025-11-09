import Composite.AlunoComponente;
import Composite.Turma;
import Singleton.Escola;

//Classe principal para demonstrar a utilização de todos os padrões de projeto.
public class Main {
    public static void main(String[] args) {
        //Primeiramente a utilização e instanciação do Singleton
        Escola escola1 = Escola.getInstancia();
        Escola escola2 = Escola.getInstancia();

        //Passando para a criação de turmas e alunos utilizando o Composite
        Turma turmaA = new Turma("Turma A");
        turmaA.adicionar(new AlunoComponente("Alice", "A001"));
        turmaA.adicionar(new AlunoComponente("Bia", "A002"));
        turmaA.adicionar(new AlunoComponente("Carlos", "A003"));
        
        Turma turmaB = new Turma("Turma B");
        turmaB.adicionar(new AlunoComponente("Diana", "B001"));
        turmaB.adicionar(new AlunoComponente("Thomas", "B002"));
        turmaB.adicionar(new AlunoComponente("Joao", "B003"));



    }
}