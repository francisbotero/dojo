package fizzbuzz.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FizzbuzzAppTest {
    /*
     * For the numbers 1 to 100, print the numbers using the following rules:
     *      if the number is evenly divisible by 3, print "fizz"
     *      if the number is evenly divisible by 5, print "buzz"
     *      if the number is evenly divisible by 15, print "fizzbuzz"
     *      otherwise print the number
     * Ex: 1 2 3    4 5    6    7 8 9    10   11 12   13 14 15
     *     1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz
     */
    static String EXPECTED_OUTPUT = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz";

    @DisabledIfEnvironmentVariable(named = "TEST_IN_DEVELOPMENT", matches = ".*")
    @Test void testTotalOutput() {
        // redirect output so we can capture
        var ogSystemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        // execute the code
        App.main(null);

        // flush the stream, set out back to console, and compare the captured output
        System.out.flush();
        System.setOut(ogSystemOut);
        var actualOutput = outputStream.toString();

        assertTrue(actualOutput.startsWith(EXPECTED_OUTPUT),
                MessageFormat.format("Expected to start\nprefix: {1}\nstring: {0}", actualOutput, EXPECTED_OUTPUT));
    }

    /*
     * For the numbers 1 to 100, print the numbers using the following rules:
     *      if the number is evenly divisible by 3, print "fizz"
     *      if the number is evenly divisible by 5, print "buzz"
     *      if the number is evenly divisible by 15, print "fizzbuzz"
     *      if the number is evenly divisible by 7, print "bang"
     *      otherwise print the number
     * Ex: 1 2 3    4 5    6    7    8 9    10   11 12   13 14   15
     *     1 2 fizz 4 buzz fizz bang 8 fizz buzz 11 fizz 13 bang fizzbuzz
     */
    static String NEW_EXPECTED_OUTPUT = "1 2 fizz 4 buzz fizz bang 8 fizz buzz 11 fizz 13 bang fizzbuzz";
    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_IN_DEVELOPMENT", matches = ".*")
    void testNewGuidingTest() {
        // redirect output so we can capture
        var ogSystemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        // execute the code
        App.main(null);

        // flush the stream, set out back to console, and compare the captured output
        System.out.flush();
        System.setOut(ogSystemOut);
        var actualOutput = outputStream.toString();

        assertTrue(actualOutput.startsWith(NEW_EXPECTED_OUTPUT),
                MessageFormat.format("Expected to start\nprefix: {1}\nstring: {0}", actualOutput, NEW_EXPECTED_OUTPUT));
    }
}
