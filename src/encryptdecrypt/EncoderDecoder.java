package encryptdecrypt;

public interface EncoderDecoder {
    String encode(String msg, int key);
    String decode(String cipher, int key);
}
