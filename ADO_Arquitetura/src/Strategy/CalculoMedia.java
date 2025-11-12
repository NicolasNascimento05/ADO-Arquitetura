package Strategy;
/*
 * Padrão de Projeto Strategy:
 * Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.
 * O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.
 */

public interface CalculoMedia {
    double calular(double[] notas);
}
