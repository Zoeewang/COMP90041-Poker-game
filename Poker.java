
import java.util.ArrayList;
import java.util.Collections;

/**

 * The Poker program implements the simpler version that characterise poker
 * hands
 */
public class Poker {
    /**
     * This main method check the input line and characterise poker hands
     * @param args cards on the command line
     */
    public static void main(String[] args) {
        // Check the validity of input length
        ValidChecker.CheckValid(args);

        //Use ArrayLists to store cards
        ArrayList<CardRank> ranks =new ArrayList<>();
        ArrayList<CardSuit> suits =new ArrayList<>();

        //create a Card object which stores cards
        for(String newCard : args){
            String rank = String.valueOf(newCard.charAt(0));
            String suit = String.valueOf(newCard.charAt(1));
            Card card = new Card(rank, suit);

            ranks.add(card.getRank());
            suits.add(card.getSuit());
        }

        // Sort ranks in ascending order
        Collections.sort(ranks);
        //Create the CardChecker object
        CardChecker checker = new CardChecker(ranks, suits);
        checker.CheckHands();
    }

}
