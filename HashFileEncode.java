import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

// <Nível 2>
public class HashFileEncode {

    public static String runProgram(String file) throws IOException, NoSuchAlgorithmException {
        System.out.println("Documento Partilhado\t\t--> " + file);
        String fileContents = new String(Files.readAllBytes(Paths.get(file)));
        String digestedShaTest = shaTest(fileContents, "SHA-256");
        System.out.println("Hash code do doc partilhado\t--> " + digestedShaTest);
        return digestedShaTest;
    }

    static String shaTest(String input, String encodingAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance(encodingAlgorithm);
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
