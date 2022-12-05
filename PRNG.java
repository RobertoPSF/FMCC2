
import static java.lang.System.currentTimeMillis;
import java.util.*;

class PRNG {
    public static void main(String[] args) {
        Random rand = new Random(currentTimeMillis());
        int i;

        for (i = 0; i < 200; i++) {
            System.out.print(rand.nextInt(100) + " ");
        }
    }
}

// This code is contributed by phasing17
