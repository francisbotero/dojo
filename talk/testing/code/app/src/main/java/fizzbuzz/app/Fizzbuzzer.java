package fizzbuzz.app;

public class Fizzbuzzer implements Translator {
    ModuloTranslator translators[];
    public Fizzbuzzer() {
        this.translators = new ModuloTranslator[]{
                new ModuloTranslator(15, "fizzbuzz"),
                new ModuloTranslator(3, "fizz"),
                new ModuloTranslator(5, "buzz")};
    }

    @Override
    public String translate(int i) {
        String output = null;
        for(var translator: this.translators) {
            output = translator.translate(i);
            if (output != null) {
                return output;
            }
        }
        return Integer.toString(i);
    }
}
