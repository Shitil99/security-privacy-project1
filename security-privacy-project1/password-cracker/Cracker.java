/*Team members-
1.Shitil Shetty
2.Vishwajeet Kulkarni
3.Pawan Sai Krishna Reddy Kerelly
*/ 

import java.io.*;
import java.util.*;

public class Cracker {
    public static void main(String[] args) throws IOException {
        BufferedReader shadowFileReader = new BufferedReader(new FileReader("shadow"));
        BufferedReader passwordFileReader = new BufferedReader(new FileReader("common-passwords.txt"));
        String line;
        Map<String, String> shadowMap = new HashMap<>();
        while ((line = shadowFileReader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length > 1) {
                shadowMap.put(parts[0], parts[1]);
            }
        }
        while ((line = passwordFileReader.readLine()) != null) {
            for (Map.Entry<String, String> entry : shadowMap.entrySet()) {
                String[] hashParts = entry.getValue().split("\\$");
                if (hashParts.length > 2) {
                    String salt = hashParts[2];
                    String hash = hashParts[3];
                    if (MD5Shadow.crypt(line.trim(), salt).equals(hash)) {
                        System.out.println(entry.getKey() + ":" + line);
                    }
                }
            }
        }
    }
}