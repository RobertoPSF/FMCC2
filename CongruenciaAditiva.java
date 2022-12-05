
class CongruenciaAditiva {

    public static void main(String[] args) {

        int Xo = 3;

        int m = 15;

        int c = 2;

        int noOfRandomNums = 200;

        int[] randomNums = new int[noOfRandomNums];

        additiveCongruentialMethod(Xo, m, c, randomNums, noOfRandomNums);

        for (int i = 0; i < noOfRandomNums; i++) {
            System.out.print(randomNums[i] + " ");
        }
    }

    static void additiveCongruentialMethod(int Xo, int m, int c, int[] randomNums, int noOfRandomNums) {
        randomNums[0] = Xo;

        for (int i = 1; i < noOfRandomNums; i++) {
            randomNums[i] = (randomNums[i - 1] + c) % m;
        }
    }
}
