import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// <Nível 1>
public class HashTextTest {

    public static void runProgram(String myPassword) throws NoSuchAlgorithmException {
        System.out.printf("digesting %s--> %s\n\n", myPassword, shaTest(myPassword, "SHA1"));
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
