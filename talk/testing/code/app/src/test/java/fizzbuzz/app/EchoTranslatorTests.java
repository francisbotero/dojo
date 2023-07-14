package fizzbuzz.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EchoTranslatorTests {
    @ParameterizedTest
    @MethodSource("translationValuesProvider")
    void testTranslation(int input, String expectedOutput) {
        final var translator = new EchoTranslator();
        var output = translator.translate(input);
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> translationValuesProvider() {
        return Stream.of(
                arguments(1, "1"),
                arguments(2, "2"),
                arguments(3, "3")
        );
    }
}
