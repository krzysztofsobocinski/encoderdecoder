package encryptdecrypt;

public class UnicodeEncoderDecoder implements EncoderDecoder {
    @Override
    public String encode(String msg, int key) {
        StringBuilder sb = new StringBuilder();

        for (char ch : msg.toCharArray()) {
            sb.append((char) (ch + key));
        }
        return sb.toString();
    }

    @Override
    public String decode(String cipher, int key) {
        StringBuilder sb = new StringBuilder();
        for (char ch : cipher.toCharArray()) {
            sb.append((char) (ch - key));
        }
        return sb.toString();
    }

}
