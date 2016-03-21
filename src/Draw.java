import java.util.Random;

/**
 * Created by Scott on 3/14/2016.
 *
 * 3/14/16 The draw method is currrently only drawing one of each card. I plan on changing it to imitate a real deck
 */
public class Draw {
    /*Draws the face of the card from a deck of 52 cards */
    static public String draw()
    {
        String cards[] = {"ace","ace","ace","ace","one","one","one","one","two","two","two","two","three","three","three","three",
                "four","four","four","four","five","five","five","five","six","six","six","six","seven","seven","seven","seven",
                "eight","eight","eight","eight","nine","nine","nine","nine","jack","jack","jack","jack","queen","queen","queen","queen","king","king","king","king"};
        int index = new Random().nextInt(cards.length);
        String face = (cards[index]);
        return face;
    }
    /*Changes the face values, which are Strings, to the actual value of the card*/
    static public int values (String card){
        int value = 0;
        switch (card) {
            case "one": value = 1;break;
            case "two": value = 2;break;
            case "three": value = 3;break;
            case "four": value = 4;break;
            case "five": value = 5;break;
            case "six": value = 6; break;
            case "seven": value = 7;break;
            case "eight": value = 8;break;
            case "nine": value = 9;break;
            case "jack": value = 10;break;
            case "queen":value = 10;break;
            case "king":value = 10;break;
            case "ace":value = 1;break;

        }
        return value;
    }
}
