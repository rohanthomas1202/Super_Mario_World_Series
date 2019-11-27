import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // hashMap to store the keys
        HashMap<String, String> key_hash = new HashMap<>();
        HashMap<String, Player> home_hash = new HashMap<>();
        HashMap<String, Player> away_hash = new HashMap<>();

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

        // read from input File
        // user entered file
        /*Scanner scan = new Scanner(System.in);
        String userFile = scan.nextLine();
        File inputFile = new File(new Scanner(System.in).nextLine());*/
        BufferedReader reader = new BufferedReader(new FileReader(new File(new Scanner(System.in).nextLine())));


        // line will hold the entire line
        String line = null;
        // h_a holds information on whether the player is from home team or away team
        Character h_a = null;
        // name of player
        String name = null;
        // key_code holds the code to search in hashMap
        String key_code = null;


        while ((line = reader.readLine()) != null) {
            h_a = line.charAt(0);
            line = line.substring(2);
            name = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" "));
            key_code = line;

            System.out.println("h_a: " + h_a + ", name = " + name + ", key_code: " + key_code);


            // check to see if the player is home or away
            // if home player, update home hashMap
            if (h_a == 'H'){
                // check if player is already in the home hashMap
                // if yes, update his stats
                if (home_hash.containsKey(name)){

                }
                // else create a new player
                else{
                    Player player = new Player();
                    player.setName(name);

                    home_hash.put(name, player);

                }
            }
            // else if away player, update away hashMap
            else if (h_a == 'A'){
                // check if player is already in the away hashMap
                // if yes, update his stats
                if (){

                }
                // else create a new player
                else{

                }
            }else{
                System.out.println("Wrong Home/Away code");
                System.out.println("check code");
            }

        }

    }

}

