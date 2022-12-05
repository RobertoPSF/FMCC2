
import static java.lang.System.currentTimeMillis;
import java.util.Random;

class PRNG2 {
  public static void main(String[] args) {
    int Xo = 5;

    int m = 200;

    int a = 11;

    int c = 1;

    int noOfRandomNums = 100000;

    int[] randomNums = new int[noOfRandomNums];

    randomNums = linearCongruentialMethod(Xo, m, a, c, randomNums, noOfRandomNums);

    for (int i = 0; i < noOfRandomNums; i++) {
      System.out.print(randomNums[i] + " ");
    }

    int[] vetorAmostra = new int[randomNums.length];

    for (int i = 0; i < noOfRandomNums; i++) {
      vetorAmostra[randomNums[i]] = vetorAmostra[randomNums[i]] + 1;
    }

    for (int i = 0; i < m; i++) {
      System.out.printf("\nNúmero %d / %d vezes", i, vetorAmostra[i]);
    }
  }

  static int[] linearCongruentialMethod(int Xo, int m, int a, int c, int[] randomNums, int noOfRandomNums) {
    Random rand = new Random(currentTimeMillis());

    int[] VetorAuxiliar = new int[noOfRandomNums];
    VetorAuxiliar[0] = Xo;

    for (int i = 1; i < noOfRandomNums; i++) {
      VetorAuxiliar[i] = ((VetorAuxiliar[i - 1] * a) + c + rand.nextInt(1000)) % m;
    }
    // Chama a função nova adicionaCamada()
    return adicionaCamada(VetorAuxiliar, noOfRandomNums, m);
  }

  private static int[] adicionaCamada(int[] vetorAuxiliar, int tamanho, int modulo) {
    // Para cada valor do vetor gerado será feita uma conta para descobrir o resto
    // da divisão por 4
    for (int i = 0; i < tamanho - 1; i++) {

      // Aqui encontrase o valor congruente a 0, 1, 2, 3 (mod 4)
      int resto = vetorAuxiliar[i] % 4;

      // Chama uma das funções dependendo da congruência
      switch (resto) {
        case 0:
          vetorAuxiliar[i] = funcSoma(vetorAuxiliar, i, modulo);
          break;
        case 1:
          vetorAuxiliar[i] = funcSubtracao(vetorAuxiliar, i, modulo);
          break;
        case 2:
          vetorAuxiliar[i] = funcMultiplicacao(vetorAuxiliar, i, modulo);
          break;
        case 3:
          vetorAuxiliar[i] = funcDivisao(vetorAuxiliar, i, modulo);
          break;
      }
    }
    return vetorAuxiliar;
  }

  private static int funcSoma(int[] vetorAuxiliar, int index, int modulo) {
    int valorBruto = vetorAuxiliar[index] + vetorAuxiliar[index + 1];
    return verificador(valorBruto, modulo);
  }

  private static int funcSubtracao(int[] vetorAuxiliar, int index, int modulo) {
    int valorBruto = vetorAuxiliar[index] - vetorAuxiliar[index + 1];
    return verificador(valorBruto, modulo);
  }

  private static int funcMultiplicacao(int[] vetorAuxiliar, int index, int modulo) {
    int valorBruto = vetorAuxiliar[index] * vetorAuxiliar[index + 1];
    return verificador(valorBruto, modulo);
  }

  private static int funcDivisao(int[] vetorAuxiliar, int index, int modulo) {
    if (vetorAuxiliar[index] != 0 && vetorAuxiliar[index + 1] != 0) {
      int valorBruto = vetorAuxiliar[index] % vetorAuxiliar[index + 1];
      return verificador(valorBruto, modulo);
    }

    else {
      return vetorAuxiliar[index];
    }
  }

  public static int verificador(int numero, int modulo) {
    // Recebe o número gerado e ajusta com relação ao modulo respeitando a função:
    // numero < modulo && numero >= 0

    if (numero < modulo && numero >= 0) {
      return numero;
    }

    else if (numero < 0) {
      while (numero < 0) {
        numero = numero + modulo;
      }
      return numero;
    }

    else {
      while (numero > modulo - 1) {
        numero = numero - modulo;
      }
      return numero;
    }
  }
}

// This code is contributed by Gustavo_Alverga
