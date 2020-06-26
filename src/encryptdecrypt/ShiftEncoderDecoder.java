package encryptdecrypt;

public class ShiftEncoderDecoder implements EncoderDecoder {
    @Override
    public String encode(String msg, int key) {
        StringBuilder sb = new StringBuilder();

        for (char ch : msg.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) ('a' + (ch + key - 'a') % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) ('A' + (ch + key - 'A') % 26));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    @Override
    public String decode(String cipher, int key) {
        StringBuilder sb = new StringBuilder();
        for (char ch : cipher.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) ('a' + (ch + 26 - key - 'a') % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) ('A' + (ch + 26 - key - 'A') % 26));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
