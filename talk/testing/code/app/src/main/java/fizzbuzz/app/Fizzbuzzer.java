package fizzbuzz.app;

public class Fizzbuzzer implements Translator {
    ModuloTranslator translators[];
    public Fizzbuzzer() {
        this.translators = new ModuloTranslator[]{ new ModuloTranslator(15, "fizzbuzz") };
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
        if (i % 3 == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else {
            return Integer.toString(i);
        }
    }
}
