/*
 * For the numbers 1 to 100, print the numbers using the following rules:
 *      if the number is evenly divisible by 3, print "fizz"
 *      if the number is evenly divisible by 5, print "buzz"
 *      if the number is evenly divisible by 15, print "fizzbuzz"
 */
package fizzbuzz.app;

import org.apache.commons.text.WordUtils;
public class App {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print("fizz");
            } else if (i % 5 == 0) {
                System.out.print("buzz");
            } else if (i % 15 == 0) {
                System.out.print("fizzbuzz ");
            }
        }
    }
}
