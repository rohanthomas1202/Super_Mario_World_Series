import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        // hashMap to store the keys
        HashMap<String, String> key_hash = new HashMap<>();
        HashMap<String, Player> home_hash = new HashMap<>();
        HashMap<String, Player> away_hash = new HashMap<>();
        ArrayList<String> home_names = new ArrayList<>();
        ArrayList<String> away_names = new ArrayList<>();
        ArrayList<String> all_names = new ArrayList<>();


        BufferedWriter writer = new BufferedWriter(new FileWriter("leaders.txt"));

        // read from "keyfile.txt"
        File infile = new File("keyfile.txt");

        BufferedReader br = new BufferedReader(new FileReader(infile));

        String str = null;
        String key = null;
        // reading the keys and storing them in hash map for easy retrial later
        while ((str = br.readLine()) != null) {
            // the String enclosed in ## ... ## contains the key
            if (str.contains("##")) {
                str = str.substring(3);
                key = str.substring(0, str.indexOf(" ##"));
                // test
                //System.out.println("key: " + key);
            } else if (!str.equals("")) {
                //System.out.println("add:\t" + str + "," + key);
                key_hash.put(str, key);
            }
        }
        // close file after use
        br.close();

        // get filename from user
        //System.out.println("Enter file name:");
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
            key_code = line.substring(1);

            // check to see if the player is home or away
            // if home player, update home hashMap
            if (h_a == 'H') {
                populate_hash(key_hash, home_hash, home_names, h_a, name, key_code, all_names);
            }
            // else if away player, update away hashMap
            else if (h_a == 'A') {
                populate_hash(key_hash, away_hash, away_names, h_a, name, key_code, all_names);
            } else {
                // should newer happen for our project
                System.out.println("Wrong Home/Away code");
                System.out.println("check code");
            }

        }

        home_names.sort(Comparator.comparing(String::toString));
        away_names.sort(Comparator.comparing(String::toString));
        all_names.sort(Comparator.comparing(String::toString));

        //System.out.println("AWAY");
        writer.write("AWAY\n");

        for (String away_name : away_names) {
            //System.out.print(away_hash.get(away_name));
            writer.write(String.valueOf(away_hash.get(away_name)));
        }

        //System.out.println();
        writer.write("\n");

        //System.out.println("HOME");
        writer.write("HOME\n");

        for (String home_name : home_names) {
            //System.out.print(home_hash.get(home_name));
            writer.write(String.valueOf(home_hash.get(home_name)));
        }


        // print league leaders
        for (int code = 0; code < 6; code++) {


            ArrayList<Integer> list = new ArrayList<>();
            /*
            Using code to determine which leaders to printout
            0 -> BATTING AVERAGE
            1 -> ON-BASE PERCENTAGE
            2 -> HITS
            3 -> WALKS
            4 -> STRIKEOUTS
            5 -> HIT BY PITCH
            */

            //Print league leaders
            if (code == 0) {
                writer.write("\nLEAGUE LEADERS\nBATTING AVERAGE\n");
                for (int i = 0; i < all_names.size(); i++){
                    if (home_hash.containsKey(all_names.get(i))){
                        System.out.println(all_names.get(i) + "is in home team");

                    }else{
                        System.out.println(all_names.get(i) + "is in away team");

                    }
                }



                Collections.sort(list);
                ArrayList<Integer> top3 = new ArrayList<Integer>(list.subList(list.size() -3, list.size()));
            } else if (code == 1) {
                writer.write("\nON-BASE PERCENTAGE\n");

            } else if (code == 2) {
                writer.write("\nHITS\n");

            } else if (code == 3) {
                writer.write("\nWALKS\n");

            } else if (code == 4) {
                writer.write("\nLEAGUE LEADERS\nBATTING AVERAGE\n");

            } else if (code == 5) {
                writer.write("\nLEAGUE LEADERS\nBATTING AVERAGE\n");

            }
        }

        writer.close();
    }


    // function which takes any Player and checks if the player is in the home/away hashMap, if not present adds a new player
    private static void populate_hash(HashMap<String, String> key_hash, HashMap<String, Player> hash, ArrayList<String> names, Character h_a, String name, String key_code, ArrayList<String> all) {
        // check if player is already in the hashMap
        // if yes, update his stats
        if (hash.containsKey(name)) {
            String this_key = key_hash.get(key_code);
            update_stat(this_key, hash.get(name));
        }
        // else create a new player
        else {
            // creating a new player
            Player player = new Player();
            // player team
            player.setHome_away(h_a);
            // new player name
            player.setName(name);
            // get the type of stat to increment
            String this_key = key_hash.get(key_code);
            // function to decide which state to increment
            update_stat(this_key, player);
            // add player to the hashMap
            hash.put(name, player);
            names.add(name);
            all.add(name);
        }
    }

    // functions which updates a player's stats
    private static void update_stat(String s, Player p) {

        switch (s) {
            case "OUTS":
                p.out_plus(1);
                break;
            case "STRIKEOUT":
                p.strikeouts_plus(1);
                break;
            case "HITS":
                p.hits_plus(1);
                break;
            case "WALK":
                p.walks_plus(1);
                break;
            case "SACRIFICE":
                p.sacrifice_plus(1);
                break;
            case "HIT BY PITCH":
                p.HBP_plus(1);
                break;
            case "ERRORS":
                p.errors_plus(1);
                break;
            default:
                break;
        }
    }
}