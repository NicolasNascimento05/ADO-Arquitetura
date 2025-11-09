package Strategy;

// Implementação concreta da estratégia de cálculo de média ponderada
public class MediaPonderada implements CalculoMedia {
    @Override
    public double calular(double[] notas) {
        double soma = 0;
        double pesoTotal = 0;
        for(int i = 0; i < notas.length; i++) {
            double peso = i + 1; // Exemplo de pesos crescentes
            soma += notas[i] * peso;
            pesoTotal += peso;
        }
        return soma / pesoTotal;
    }
}
