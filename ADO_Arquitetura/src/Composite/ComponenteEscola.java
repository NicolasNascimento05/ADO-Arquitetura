package Composite;

/**
 * Contrato do composite: qualquer componente da "árvore" deve saber exibir suas informações.
 * Mantém a API simples e permite tratar Aluno e Turma de forma uniforme.
 */
public interface ComponenteEscola {
    void exibirInformacoes();
}
