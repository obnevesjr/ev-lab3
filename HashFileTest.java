import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;



public class HashFileTest {

    public static void runProgram(String document, String documentHash) throws NoSuchAlgorithmException, IOException {
        boolean result = verifyChecksum(document, documentHash);
        if (result) {
            System.out.println("Parabens, a sua versão do documento é (quase 100% garantidamente) fidedigna...");
        } else {
            System.out.println("Cuidado, a sua versão do jdk está corrompida...");
        }
    }

    public static boolean verifyChecksum(String file, String testChecksum) throws NoSuchAlgorithmException, IOException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);

        byte[] data = new byte[1024];
        int read = 0;
        while ((read = fis.read(data)) != -1) {
            sha1.update(data, 0, read);
        };
        byte[] hashBytes = sha1.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashBytes.length; i++) {
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String fileHash = sb.toString();

        fis.close();

        return fileHash.equals(testChecksum);
    }

}
