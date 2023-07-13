package fizzbuzz.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ModuloTranslatorTests {
    @ParameterizedTest
    @MethodSource("translationValuesProvider")
    void testTranslation(int input, String expectedOutput) {
        final var translator = new ModuloTranslator(3, "fizz");
        var output = translator.translate(input);
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> translationValuesProvider() {
        return Stream.of(
                arguments(3, "fizz"),
                arguments(6, "fizz"),
                arguments(9, "fizz"),
                arguments(5, null)
        );
    }
}
