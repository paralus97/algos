package challengequestions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.toList;

public class CountElementsGreaterThanPreviousAverage {

    /**
     *
     * Given an array of positive integers, return the number of elements
     * that are strictly greater than the average of all previous elements.
     * Skip the first element.
     *
     * Input: responseTimes = [100, 200, 150,300]
     *
     * Output: 2
     *
     *
     * Explanation of output
     * - Day 0: 100 (no previous days, skip)
     * - Day 1: 200 > average(100) = 100 → count = 1
     * - Day 2: 150 vs average(100, 200) = 150 → not greater → count = 1
     * - Day 3: 300 > average(100, 200, 150) = 150 → count = 2 Return 2.
     *
     * Input Format...
     * The first line contains an integer n (0 ≤ n ≤ 1000), the number of days.
     * If n > 0, the next n lines contains an integer representing responseTimes[i].
     * If n = 0, the second line is omitted or empty.
     *
     * Example input
     * 4
     * 100
     * 200
     * 150
     * 300
     *
     */
    class Result {

        /*
         * Complete the 'countResponseTimeRegressions' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY responseTimes as parameter.
         */

        public static int countResponseTimeRegressions(List<Integer> responseTimes) {

            // calculate a moving average as we iterate through response times
            // We're gonna get some remainders, make sure its truncated
            // Spec says to skip first line of input
            // Still check for an empty list maybe?

            // CAVEAT: Dont use ints for average. Use double which allows precise comparison
            //         and also protects against integer overflow
            int responseTimeRegressions = 0;
            if (!responseTimes.isEmpty() && responseTimes.size() > 1) {
                double movingSum = responseTimes.get(0);
                for (int i = 1; i < responseTimes.size(); i++) {
                    double responseTime = responseTimes.get(i);
                    if (average(movingSum, i) < responseTime) {
                        responseTimeRegressions++;
                    }
                    movingSum += responseTime;
                }
            }
            return responseTimeRegressions;
        }

        public static double average(double sum, double numCount) {
            return sum / numCount;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.countResponseTimeRegressions(responseTimes);

            System.out.println(result);

            bufferedReader.close();
        }
    }

}
