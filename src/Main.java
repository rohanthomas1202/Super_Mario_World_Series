import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        // hashMap to store the keys
        HashMap<String, String> key_hash = new HashMap<>();

        // read from "keyfile.txt"
        File file = new File("keyfile.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = null;
        String key = null;
        // reading the keys and storing them in hash map for easy retrial later
        while ((str = br.readLine()) != null) {
            // the String enclosed in ## ... ## contains the key
            if (str.contains("##")) {
                str = str.substring(3);
                key = str.substring(0, str.indexOf(" ##"));
                // test
                System.out.println("key: " + key);
            } else if (!str.equals("")) {
                System.out.println("add:\t" + str + "," + key);
                key_hash.put(str, key);
            }
        }
        // close file after use
        br.close();

        // test
        System.out.println();

        System.out.println(key_hash.size());





    }

}

