package Strategy;

// Implementação concreta da estratégia de cálculo de média ponderada
public class MediaPonderada implements CalculoMedia {
    private double[] pesos;

    // construtor padrão usa pesos crescentes (1,2,3,...)
    public MediaPonderada() {
        this.pesos = null;
    }

    // construtor que permite fornecer pesos personalizados
    public MediaPonderada(double[] pesos) {
        this.pesos = (pesos != null) ? pesos.clone() : null;
    }

    @Override
    public double calular(double[] notas) {
        if (notas == null || notas.length == 0) return 0;
        if (pesos == null) {
            double soma = 0;
            double pesoTotal = 0;
            for (int i = 0; i < notas.length; i++) {
                double peso = i + 1;
                soma += notas[i] * peso;
                pesoTotal += peso;
            }
            return soma / pesoTotal;
        } else {
            int n = Math.min(notas.length, pesos.length);
            double soma = 0;
            double pesoTotal = 0;
            for (int i = 0; i < n; i++) {
                soma += notas[i] * pesos[i];
                pesoTotal += pesos[i];
            }
            // se houver mais notas que pesos, trate os restantes com peso 1
            for (int i = n; i < notas.length; i++) {
                soma += notas[i] * 1.0;
                pesoTotal += 1.0;
            }
            return (pesoTotal == 0) ? 0 : soma / pesoTotal;
        }
    }
}
