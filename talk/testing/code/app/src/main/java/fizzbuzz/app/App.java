/*
 * For the numbers 1 to 100, print the numbers using the following rules:
 *      if the number is evenly divisible by 3, print "fizz"
 *      if the number is evenly divisible by 5, print "buzz"
 *      if the number is evenly divisible by 15, print "fizzbuzz"
 *      otherwise print the number
 * Ex: 1 2 3    4 5    6    7 8 9    10   11 12   13 14 15
 *     1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz
 */
package fizzbuzz.app;

import org.apache.commons.text.WordUtils;
public class App {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.print("fizzbuzz");
            }
            else if (i % 3 == 0) {
                System.out.print("fizz");
            } else if (i % 5 == 0) {
                System.out.print("buzz");
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
