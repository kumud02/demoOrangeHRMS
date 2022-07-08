package utility;


import java.math.BigInteger;

public class DataGeneratorUtil {

    private static ThreadLocal<String> testId = new ThreadLocal<>();


    public static void setTestId(String testName) {
        DataGeneratorUtil.testId.set(testName);
    }

    public static String generateIMEI() {
        return NumberRandomizerUtil.getRandomBigIntInRange(
                new BigInteger("100000000000000"),
                new BigInteger("999999999999999")).toString();
    }

    public static String generateICCID() {
        return NumberRandomizerUtil.getRandomBigIntInRange(
                new BigInteger("10000000000000000000"),
                new BigInteger("99999999999999999999")).toString();
    }

}
