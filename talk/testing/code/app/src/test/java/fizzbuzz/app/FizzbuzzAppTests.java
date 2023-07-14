package fizzbuzz.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest
    @MethodSource("originalTranslationValuesProvider")
    void testOriginalTranslation(int input, String expectedOutput) {
        final var fizzBuzzer = App.ORIGINAL_FIZZBUZZ_CONFIG;
        var output = fizzBuzzer.translate(input);
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> originalTranslationValuesProvider() {
        return Stream.of(
                arguments(1, "1"),
                arguments(2, "2"),
                arguments(3, "fizz"),
                arguments(4, "4"),
                arguments(5, "buzz"),
                arguments(6, "fizz"),
                arguments(9, "fizz"),
                arguments(10, "buzz"),
                arguments(15, "fizzbuzz"),
                arguments(20, "buzz"),
                arguments(30, "fizzbuzz"),
                arguments(45, "fizzbuzz")
        );
    }

    @ParameterizedTest
    @MethodSource("newTranslationValuesProvider")
    void testNewTranslation(int input, String expectedOutput) {
        final var fizzBuzzer = App.NEW_FIZZBUZZ_CONFIG;
        var output = fizzBuzzer.translate(input);
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> newTranslationValuesProvider() {
        return Stream.of(
                arguments(1, "1"),
                arguments(2, "2"),
                arguments(3, "fizz"),
                arguments(4, "4"),
                arguments(5, "buzz"),
                arguments(6, "fizz"),
                arguments(7, "bang"),
                arguments(9, "fizz"),
                arguments(10, "buzz"),
                arguments(14, "bang"),
                arguments(15, "fizzbuzz"),
                arguments(20, "buzz"),
                arguments(21, "fizzbang"),
                arguments(28, "bang"),
                arguments(30, "fizzbuzz"),
                arguments(35, "buzzbang"),
                arguments(42, "fizzbang"),
                arguments(45, "fizzbuzz"),
                arguments(63, "fizzbang"),
                arguments(70, "buzzbang"),
                arguments(105, "fizzbuzzbang"),
                arguments(140, "buzzbang"),
                arguments(210, "fizzbuzzbang"),
                arguments(315, "fizzbuzzbang")
        );
    }
}
