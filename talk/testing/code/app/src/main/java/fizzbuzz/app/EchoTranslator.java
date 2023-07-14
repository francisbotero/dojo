package fizzbuzz.app;

public class EchoTranslator implements Translator {
    @Override
    public String translate(int i) {
        return Integer.toString(i);
    }
}
