package Singleton;

import Composite.Turma;

import java.util.ArrayList;
import java.util.List;

/* Padrão de Projeto Singleton:
 * Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
 * Neste exemplo, a classe Escola é implementada como um Singleton.
 */

public class Escola {
    private static Escola instancia;
    private List<Turma> turmas = new ArrayList<>();

    // Construtor privado para evitar instanciação externa
    private Escola(){}

    // Metodo público estático para obter a instância única
    public static Escola getInstancia () {
        if (instancia == null) {
            instancia = new Escola();
        }
        return instancia;
    }

    public void adicionarTurma (Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}
