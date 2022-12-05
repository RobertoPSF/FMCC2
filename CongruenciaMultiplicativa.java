
class CongruenciaMultiplicativa {

    public static void main(String[] args) {

        int Xo = 3;

        int m = 20;

        int a = 3;

        int noOfRandomNums = 200;

        int[] randomNums = new int[noOfRandomNums];

        multiplicativeCongruentialMethod(Xo, m, a, randomNums, noOfRandomNums);

        for (int i = 0; i < noOfRandomNums; i++) {
            System.out.print(randomNums[i] + " ");
        }
    }

    static void multiplicativeCongruentialMethod(int Xo, int m, int a, int[] randomNums, int noOfRandomNums) {

        randomNums[0] = Xo;

        for (int i = 1; i < noOfRandomNums; i++) {
            randomNums[i] = (randomNums[i - 1] * a) % m;
        }
    }
}

// This code is contributed by offbeat
