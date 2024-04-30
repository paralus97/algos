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
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Brokerage {

    static final double BROKER_BUY_CHARGES = 0.002;
    static final double BROKER_SELL_CHARGES = 0.004;

    /*
     * Complete the 'calculateTotalBrokerage' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts INTEGER_ARRAY tradesArray as parameter.
     */

    public static double calculateTotalBrokerage(List<Integer> tradesArray) {
        System.out.println(tradesArray);

        // { Size of Trades list, (Buy Price, Profit)
        // Brokerage fee for 100 buy price = 100 * 0.002 = 0.2
        // Brokerage fee for sell price profit/loss = (100 + 5) * 0.004 = 0.42 // total 0.62
        double brokerageFee = 0.0;
        double buyPrice = 0.0;
        for (int i = 0; i < tradesArray.size(); i++) {
            // first block executed if 0, 2, 4, etc
            // second on  1, 3, 5 etc.
            if (i == 0 || i % 2 == 0) {
                buyPrice = tradesArray.get(i);
                brokerageFee += (buyPrice * BROKER_BUY_CHARGES);
                System.out.println(brokerageFee);
            } else {
                double profit = buyPrice + tradesArray.get(i);
                brokerageFee += (profit * BROKER_SELL_CHARGES);
            }
        }
        // round to two decimal places
        return (double) Math.round(brokerageFee * 100) / 100;
    }

}