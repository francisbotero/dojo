package fizzbuzz.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FizzbuzzerTests {
    @ParameterizedTest
    @MethodSource("translationValuesProvider")
    void testTranslation(int input, String expectedOutput) {
        final var fizzBuzzer = new Fizzbuzzer();
        var output = fizzBuzzer.translate(input);
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> translationValuesProvider() {
        return Stream.of(
                arguments(3, "fizz"),
                arguments(6, "fizz"),
                arguments(9, "fizz"),
                arguments(5, "buzz"),
                arguments(10, "buzz"),
                arguments(20, "buzz"),
                arguments(15, "fizzbuzz"),
                arguments(30, "fizzbuzz"),
                arguments(45, "fizzbuzz"),
                arguments(1, "1"),
                arguments(2, "2"),
                arguments(4, "4")
        );
    }
}
