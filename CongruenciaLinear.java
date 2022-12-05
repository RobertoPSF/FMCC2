
class CongruenciaLinear {
    public static void main(String[] args) {
        // Número inicial
        int seed = 5;

        // Módulo que delimita o resto da divisão
        int modulo = 7;

        // Fator multiplicador
        int multiplicador = 3;

        // Número do incremento
        int incremento = 3;

        // Número que delimita quantos números serão gerados
        int tamanhoDoVetor = 200;

        // Declaração do vetor de tamanho definido
        int[] vetorFinal = new int[tamanhoDoVetor];

        // Chamada da função
        linearCongruentialMethod(seed, modulo, multiplicador, incremento, vetorFinal, tamanhoDoVetor);

        // Print do vetor
        for (int i = 0; i < tamanhoDoVetor; i++) {
            System.out.print(vetorFinal[i] + " ");
        }
    }

    static void linearCongruentialMethod(int seed, int modulo, int multiplicador, int incremento, int[] vetorFinal,
            int tamanhoDoVetor) {

        vetorFinal[0] = seed;

        for (int i = 1; i < tamanhoDoVetor; i++) {
            vetorFinal[i] = ((vetorFinal[i - 1] * multiplicador) + incremento) % modulo;
        }
    }
} // This code is contributed by offbeat
