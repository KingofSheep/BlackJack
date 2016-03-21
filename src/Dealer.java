/**
 * Created by Scott on 3/14/2016.
 * A supposedly complex equation to determine if a dealer should "hit" or "stay" in a game of BlackJack
 *
 * 3/14/16 Currently extremely simple, will change to a more complex and accurate formula later
 */
public class Dealer {

    static public String DealerA(int dealervalue){
        String results = "stay";
        if (dealervalue < 16){
            results = "hit";
        }
        return results;
    }
}
