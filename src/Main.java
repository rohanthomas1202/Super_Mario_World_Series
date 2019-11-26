import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> key_hash = new HashMap<>();

        File file = new File("keyfile.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = null;
        String key = null;
        // reading the keys and storing them in hash map for easy retrial later
        while ((st = br.readLine()) != null) {
            // the String enclosed in ## ... ## contains the key
            if (st.contains("##")) {
                st = st.substring(3);
                key = st.substring(0, st.indexOf(" ##"));
                // test
                System.out.println("key: " + key);
            } else if (!st.equals("")) {
                System.out.println("add:\t" + st + "," + key);
                key_hash.put(st, key);
            }

        }
        // close file after use
        br.close();

        // test
        System.out.println();
        System.out.println(key_hash.size());
    }

}

