/*Team members-
1.Shitil Shetty
2.Vishwajeet Kulkarni
3.Pawan Sai Krishna Reddy Kerelly
 */ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.*;

public class SimpleCracker {

    public static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

    public static void main(String[] args) {
        try {
            BufferedReader shadowReader = new BufferedReader(new FileReader("shadow-simple"));
            BufferedReader commonReader = new BufferedReader(new FileReader("common-passwords.txt"));
            String line;

            List<String> commonPasswords = new ArrayList<>();
            while ((line = commonReader.readLine()) != null) {
                commonPasswords.add(line.trim());
            }

            while ((line = shadowReader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String salt = parts[1];
                String hash = parts[2];

                for (String commonPassword : commonPasswords) {
                    String saltedPassword = salt + commonPassword;
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] hashedBytes = md.digest(saltedPassword.getBytes());
                    String hashedPassword = toHex(hashedBytes);

                    if (hashedPassword.equals(hash)) {
                        System.out.println(username + ":" + commonPassword);
                        break;
                    }
                }
            }

            shadowReader.close();
            commonReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
