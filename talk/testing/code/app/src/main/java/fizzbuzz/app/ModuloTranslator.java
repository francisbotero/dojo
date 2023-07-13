package fizzbuzz.app;

public class ModuloTranslator implements Translator {

    int modulo;
    String message;
    ModuloTranslator(int modulo, String message) {
        this.modulo = modulo;
        this.message = message;
    }
    @Override
    public String translate(int i) {
        if (i % this.modulo == 0) {
            return message;
        }
        return null;
    }
}
