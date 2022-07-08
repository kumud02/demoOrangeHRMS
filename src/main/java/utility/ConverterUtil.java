package utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterUtil {

    public static String numToHexBigEndian(int value) {
        return String.format("%02X", value);
    }

    public static String numToHexLittleEndian(int value) {
        return String.format("%08X", Integer.reverseBytes(value)).substring(0, 4).toUpperCase();
        //return Integer.toHexString(Integer.reverseBytes(value)).substring(0, 4).toUpperCase();
    }

    public static String numToBinStrBigEndian(int value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0');
    }

    public static String numToBinStrLittleEndian(int value) {
        StringBuilder stringBuilder = new StringBuilder(numToBinStrBigEndian(value));
        return stringBuilder.reverse().toString();
    }

    public static Integer binStrBigEndianToNum(String value) {
        return Integer.parseInt(value, 2);
    }

    public static Integer binStrLittleEndianToNum(String value) {
        StringBuilder stringBuilder = new StringBuilder(value);
        return binStrBigEndianToNum(stringBuilder.reverse().toString());
    }

    public static Double fahrenheitToCelsius(Double fahrenheit) {
        return ((fahrenheit - 32) * 5) / 9;
    }

    public static Double celsiusToFahrenheit(Double celsius) {
        return new BigDecimal(9 * celsius / 5 + 32)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public static Integer getNumberFromString(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }
}
