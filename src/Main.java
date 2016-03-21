/**
 * Created by Henry C. Wong on 2/27/2016.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> cards4table = new ArrayList<String>();
        ArrayList<String> cards4tableD = new ArrayList<String>();
        boolean lose = false;
        int MAX_CARDS = 5;
        int dealer1value=0, dealer2value=0, player1value=0, player2value =0, cardvalue = 0;
        String dealer1 = Draw.draw();
        String dealer2 = Draw.draw();
        cards4tableD.add(dealer1);
        cards4tableD.add(dealer2);
        String player1 = Draw.draw();
        String player2 = Draw.draw();
        String dealersplay = "stay";
        cards4table.add(player1);
        cards4table.add(player2);
        System.out.println("_________________________________________________");
        System.out.println("Dealer: " + dealer1  + "  " + dealer2);
        System.out.println("You: "    + player1  + "  " + player2);
        System.out.println("_________________________________________________");

        /*The dealer's cards convert from face values to actual numbers*/
        dealer1value = Draw.values(dealer1);
        dealer2value = Draw.values(dealer2);
        if (player1 == "ace"){player1value = Aces.aces();}
        else {player1value = Draw.values(player1);}
        if (player2 == "ace"){player2value = Aces.aces();}
        else {player2value = Draw.values(player2);}

        /*Adds up the card values for the dealer and the player*/
        int dealersvalue = dealer1value + dealer2value;
        int playersvalue = player1value + player2value;
        System.out.print("Your score: " + playersvalue);
        System.out.println("      Dealer's Score: " + dealersvalue);

        /*Winning Conditions if the player or the computer gets a blackjack*/
        if(playersvalue == 21){
            System.out.println("BlackJack! You Win!");
        }
        else if(dealersvalue == 21)
        {
            System.out.println("Dealer get a BlackJack! You Lose!");
        }
        System.out.println("Dealer goes first!");

        /*The dealers plays his/her first move
        * All of the dealer's cards are put into an arrayList called cards4tableD which is printed out on the board*/
        for (int i=0;i<4;i++){
            dealersplay = Dealer.DealerA(dealersvalue);   //calls the Dealer method to determine if to hit or stay
            switch (dealersplay){
                case "hit":
                    String dealerN = Draw.draw();
                    cards4tableD.add(dealerN);
                    int dealerNvalue = Draw.values(dealerN);
                    dealersvalue += dealerNvalue;
                    break;
                default:
                    break;
            }
            if(dealersvalue > 21){
                System.out.println("Dealer Busts! You Win!");
                lose = false;
                break;
            }
            if (i==4 && dealersvalue < 21){
                System.out.println("Dealer has 5 cards! \n You Lose");
                lose = true;
            }
        }

        /*Prints the board for the player to see what the dealer got*/
            System.out.println("_________________________________________________");
            System.out.print("Dealers: ");
            for (int i = 0; i < cards4tableD.size(); i++) {
                System.out.print(cards4tableD.get(i) + "  ");
            }
            System.out.println("\nYou: " + player1 + "  " + player2);
            System.out.println("\n_________________________________________________");

        /*Shows what the current score is before the player plays*/
            System.out.print("Your score: " + playersvalue);
            System.out.println("      Dealer's New Score: " + dealersvalue + "\n Now it's your turn");

        /*Hit or stay player system
        * During this time it takes all the hits and stores it into the arraylist cards4table and prints them out*/
        if(lose = true) {
            for (int i = 0; i < 4; i++) {
                System.out.println("Do you want to Hit or Stay? (type \"hit\" or \"stay\") ");
                String playersplay = scan.nextLine();
                switch (playersplay) {
                    case "hit":
                        String playern = Draw.draw();
                        cards4table.add(playern);
                        if (playern == "ace") {        // if there is an ace it will ask the player 1 or 11?
                            cardvalue = Aces.aces();
                        } else {
                           cardvalue = Draw.values(playern);}
                        playersvalue += cardvalue;
                        System.out.println("_________________________________________________");
                        System.out.print("Dealer: ");
                        for (int j = 0; j < cards4tableD.size(); j++) {                   //prints dealers cards on the table
                            System.out.print(cards4tableD.get(j) + "  ");
                        }
                        System.out.print("\nYou: ");
                        for (int j = 0; j < cards4table.size();j++) {                     //prints the player's cards on the table
                            System.out.print(cards4table.get(j) + "  ");
                        }
                        System.out.println("\n_________________________________________________");
                        break;
                    default:
                        break;
                }
                if (i == 4 || (playersvalue > dealersvalue && playersvalue <= 21))   // sets the winning conditions
                    System.out.println("Congratulations, You Win!");
            }
        }
        else
            System.out.println("GAME OVER");

    }
}