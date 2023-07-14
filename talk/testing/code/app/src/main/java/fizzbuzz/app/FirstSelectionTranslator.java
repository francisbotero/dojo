package fizzbuzz.app;

public class FirstSelectionTranslator implements Translator {
    Translator translators[];
    public FirstSelectionTranslator(Translator[] translators) {
        this.translators = translators;
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
