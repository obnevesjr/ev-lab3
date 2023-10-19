import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TestProject {
    public static void main(String[] args) throws Exception {
        System.out.println("<Nível 1>");
        HashTextTest.runProgram("!@#$%^&*");
        System.out.println("<Nível 2>");
        String hash = HashFileEncode.runProgram("./lusiadas.txt");
        HashFileTest.runProgram("./lusiadas.txt", hash);
        System.out.println("\n<Nível 3>");
        RsaExample.runProgram();
    }
}
