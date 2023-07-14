package fizzbuzz.app;

public class AccumulationTranslator implements Translator {
    Translator translators[];
    public AccumulationTranslator(Translator[] translators) {
        this.translators = translators;
    }

    @Override
    public String translate(int i) {
        StringBuilder sb = new StringBuilder();
        boolean atLeastOneMatch = false;
        for(var translator: this.translators) {
            var output = translator.translate(i);
            if (output != null) {
                sb.append(translator.translate(i));
                atLeastOneMatch = true;
            }
        }
        return atLeastOneMatch ? sb.toString() : null;
    }
}
