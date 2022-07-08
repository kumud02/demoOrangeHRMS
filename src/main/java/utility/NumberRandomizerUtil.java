package utility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class NumberRandomizerUtil {

    public static int getRandomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static BigInteger getRandomBigIntInRange(BigInteger min, BigInteger max) {
        BigInteger bigInt = max.subtract(min);
        Random rand = new Random();
        int maxNumBitLength = max.bitLength();
        BigInteger randBigInt = new BigInteger(maxNumBitLength, rand);
        if (randBigInt.compareTo(min) < 0)
            randBigInt = randBigInt.add(min);
        if (randBigInt.compareTo(max) >= 0)
            randBigInt = randBigInt.mod(bigInt).add(min);
        return randBigInt;
    }

    public static double getRandomDoubleInRange(double min, double max) {
        Random rand = new Random();
        double value = rand.nextDouble() * (max - min) + min;
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
