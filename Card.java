
/**

 * This class is used to represent cards
 */
public class Card {
    private final CardRank rank;
    private final CardSuit suit;

    /**
     * This method is used to turn the command line arguments into enum
     * @param rank
     * @param suit
     */
    public Card(String rank, String suit) {
        this.rank = CardRank.fromString(rank);
        this.suit = CardSuit.fromString(suit);

        // check the validity of suits and ranks
        if(this.rank == null || this.suit == null){
            System.out.println("Error: invalid card name '"
                    +(rank + suit) + "'");
            System.exit(0);
        }
    }

    //Accessor
    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }



}



