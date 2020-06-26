package encryptdecrypt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String cmd = "enc";
        String msg = "";
        String alg = "shift";
        int key = 0;
        boolean dataPresent = false;
        PrintStream pw = System.out;

        int i = 0;
        while (i < args.length) {
            String option = args[i].substring(1);
//            System.out.println(option);
            ++i;
            switch (option) {
                case "mode":
                    cmd = args[i];
                    break;
                case "key":
                    key = Integer.parseInt(args[i]);
                    break;
                case "data":
                    msg = args[i];
                    dataPresent = true;
                    break;
                case "in":
                    if (!dataPresent) {
                        try {
                            msg = Files.readString(Paths.get(args[i]));
                        } catch (IOException e) {
                            System.out.println("Error error reading input file: " + e.getMessage());
                            return;
                        }
                    }
                    break;
                case "out":
                    try {
                        pw = new PrintStream(new FileOutputStream(new File(args[i])));
                    } catch (IOException e) {
                        System.out.println("Error outputting to file: " + e.getMessage());
                        return;
                    }
                    break;
                case "alg":
                    alg = args[i];
                    break;

                default:
                    System.err.println("Unknown mode");
                    return;
            }
            ++i;
        }

        Main main = new Main();
        EncoderDecoder encoderDecoder = EncoderDecoderFactory.getEncoderDecoder(alg);
        String sb = cmd.equals("enc") ? encoderDecoder.encode(msg, key) : encoderDecoder.decode(msg, key);

        pw.println(sb);
    }


}
