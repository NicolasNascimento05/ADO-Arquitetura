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
}
