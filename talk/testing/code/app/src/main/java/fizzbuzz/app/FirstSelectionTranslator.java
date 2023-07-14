package fizzbuzz.app;

public class FirstSelectionTranslator implements Translator {
    Translator translators[];
    public FirstSelectionTranslator() {
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
