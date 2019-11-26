//import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*******************************
 ** Name    - Rohan Sam Thomas **
 ** UTDID   - RST170000        **
 ** Class   - CS2336           **
 ** Date    - 10/017/2019      **
 ** JDK     - 11               **
 ** IDE     - IntelliJ Idea    **
 ********************************/
public class Player implements Comparable<Player> {
    private String name;
    private NumberFormat formatter = new DecimalFormat("#0.000");
    private int hits;           // H;
    private int walks;          // W;
    private int strikeouts;     // K;
    private int hit_by_pitch;   // P;
    private int out;            // O;
    private int sacrifice;      // S;

    // default constructor
    Player() {
        name = "swap";
        hits = 0;
        walks = 0;
        strikeouts = 0;
        hit_by_pitch = 0;
        out = 0;
        sacrifice = 0;
    }

    //NAME
    ////////////////////////
    void setName(String n) {
        name = n;
    }

    String getName() {
        return name;
    }
    ////////////////////////

    //HITS
    ////////////////////////
    void sethits(int h) {
        hits = h;
    }

    void hits_plus(int h) {
        hits = (hits + h);
    }

    int gethits() {
        return hits;
    }
    ////////////////////////

    //WALKS
    ////////////////////////
    void setwalks(int w) {
        walks = w;
    }

    void walks_plus(int w) {
        walks = (walks + w);
    }

    int getwalks() {
        return walks;
    }
    ////////////////////////

    //STRIKEOUTS
    ////////////////////////
    void setstrikeouts(int s) {
        strikeouts = s;
    }

    void strikeouts_plus(int s) {
        strikeouts = (strikeouts + s);
    }

    int getstrikeouts() {
        return strikeouts;
    }
    ////////////////////////


    //Hits_By_Pitch
    ////////////////////////
    void setHBP(int hbp) {
        hit_by_pitch = hbp;
    }

    void HBP_plus(int h) {

        hit_by_pitch = (hit_by_pitch + h);
    }

    int getHBP() {


        return hit_by_pitch;
    }
    ////////////////////////


    //OUT
    ////////////////////////
    void setout(int o) {
        out = o;
    }

    void out_plus(int o) {
        out = (out + o);
    }

    public int getout() {
        return out;
    }
    ////////////////////////

    //SACRIFICE
    ////////////////////////
    void setsacrifice(int s) {
        sacrifice = s;
    }

    void sacrifice_plus(int s) {
        sacrifice = (sacrifice + s);
    }

    private int getsacrifice() {
        return sacrifice;
    }
    ////////////////////////


    //CALCULATE BA when required
    ////////////////////////
    double calculate_BA() {
        double BA = 0.000;
        if ((hits + out + strikeouts) != 0) {
            BA = (((hits) / (double) (hits + out + strikeouts)));
        }
        int places = 3;
        BA = round(BA, places);
        return BA;
    }
    ////////////////////////

    //CALCULATE OB when required
    ////////////////////////
    double calculate_OB() {
        double OB = 0.000;
        if ((hits + out + strikeouts + walks + hit_by_pitch + sacrifice) != 0) {
            OB = ((hits + walks + hit_by_pitch) / (double) (hits + out + strikeouts + walks + hit_by_pitch + sacrifice));
        }
        int places = 3;
        OB = round(OB, places);
        return OB;
    }

    private int calculate_atBat() {
        //hit bats are (hits + strikeouts + out)
        return hits + strikeouts + out;
    }
    ////////////////////////


    @Override
    public String toString() {
        //return ("NA \t Ab \t H \t W \t K \t HP \t S \t BA \t OB \n" + name + "\t" + calculate_atBat() + "\t" + gethits() + "\t" + getwalks() + "\t" + getstrikeouts() + "\t" + getHBP() + "\t" + getsacrifice() + "\t" + calculate_BA() + "\t" + calculate_OB() + "\n");
        return (name + "\t" + calculate_atBat() + "\t" + gethits() + "\t" + getwalks() + "\t" + getstrikeouts() + "\t" + getHBP() + "\t" + getsacrifice() + "\t" + formatter.format(calculate_BA()) + "\t" + formatter.format(calculate_OB()) + "\n");
        //return null;
    }

    @Override
    public int compareTo(Player player) {
        return 0;
    }
}