import java.util.Scanner;

/**
 * Created by Scott on 3/14/2016.
 * Lets the user determine if the Ace will be a One or Zero
 *
 * 3/14/15 Still need to deal with java.util.InputMismatchException
 */
public class Aces {
    static public int aces() {
        Scanner scan = new Scanner(System.in);
        System.out.println("You have an Ace \n Do you want your ace to be a 1 or an 11?");
        int ace = 0;
        Boolean s = false;
        System.out.println("(Enter 1 or 11)");
        while(s == false){
            int aceanswer = scan.nextInt();
            switch (aceanswer){
                case 11:ace = 11;s = true;break;
                case 1:ace = 1;s = true;break;
                default:System.out.println("Please enter only a one or eleven");break;
            }
        }
        return ace;
    }
}
