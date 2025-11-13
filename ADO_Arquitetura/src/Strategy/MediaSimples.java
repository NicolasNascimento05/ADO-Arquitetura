package Strategy;

// Implementação concreta da estratégia de cálculo de média simples
public class MediaSimples implements CalculoMedia {
    @Override
    public double calular(double[] notas) {
        double soma = 0;
        for(double n : notas) soma += n;
        return soma / notas.length;
    }
}
