package com.codewars.regex_for_binary_divisible_for_five;

import logger.MyLogger;

import java.util.regex.Pattern;

/**
 * Created by guilherme-lima on 10/02/19.
 * https://github.com/guilherme-lima
 */
public class RegexForBinaryDivisibleForFive extends MyLogger {

    private static Object[][] testArr = new Object[][] {
            new Object[] {false, "" },
            new Object[] {false, "abc"},
            new Object[] {true,  "000"},
            new Object[] {true,  "101"},
            new Object[] {true,  "1010"},
            new Object[] {true,  "10100"},
            new Object[] {true,  Integer.toBinaryString(65020)},

            new Object[] {false, "10110101"},
            new Object[] {false, "1110001"},

            new Object[] {false,  Integer.toBinaryString(21)},
            new Object[] {false,  Integer.toBinaryString(15392)},
            new Object[] {false,  Integer.toBinaryString(23573)},
            new Object[] {false,  Integer.toBinaryString(19344)},

            new Object[] {false,  Integer.toBinaryString(43936)},
            new Object[] {false,  Integer.toBinaryString(32977)},
            new Object[] {false,  Integer.toBinaryString(328)},
            new Object[] {false,  Integer.toBinaryString(5729)}
    };


    public static void main(String[] args) {
        for (Object[] arr: testArr) {
            boolean exp    = (boolean) arr[0];
            String  toTest = (String) arr[1];
            boolean result = RegexForBinaryDivisibleForFive.pattern().matcher(toTest).matches();
            String resultStr = exp == result ? "[CORRECT]" : "[INCORRECT]";
            LOGGER.info(resultStr + " Expected: " + exp + " Found: " + result + "\t\tfor: " + toTest);
        }
    }

    private static Pattern pattern() {
        return Pattern.compile("^(0+|1(10)*(0|11)(01*01|01*00(10)*(0|11))*1)+$");
    }
}