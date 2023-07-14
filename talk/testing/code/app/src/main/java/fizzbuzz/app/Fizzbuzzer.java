package fizzbuzz.app;

public class Fizzbuzzer implements Translator {
    Translator translators[];
    public Fizzbuzzer() {
        this.translators = new Translator[]{
                new AccumulationTranslator(),
                new EchoTranslator()};
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
        return null;
    }
}
