package encryptdecrypt;

public class EncoderDecoderFactory {
    public static EncoderDecoder getEncoderDecoder(String alg) {
        switch (alg) {
            case "shift":
                return new ShiftEncoderDecoder();
            case "unicode":
                return new UnicodeEncoderDecoder();
        }
        return null;
    }
}
