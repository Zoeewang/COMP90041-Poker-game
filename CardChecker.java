
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**

 * This class is used to check the classifictaions of hands of the inpu† cards
 */
public class CardChecker {
    private final ArrayList<CardRank> ranks;
    private final ArrayList<CardSuit> suits;

    /**
     * This constructor is used to create an CardChecker object which
     * contains ranks and suits and initialize these instance variables
     * @param ranks This is the ArrayList which stores the ranks of cards
     * @param suits This is the ArrayList which stores the suits of cards
     */
    public CardChecker(ArrayList<CardRank> ranks, ArrayList<CardSuit> suits){
        this.suits = suits;
        this.ranks = ranks;
    }

    /**
     * This method is used to create a HashMap, the keys store the ranks of
     * cards and the values store the frequency of each rank
     * @param ranks This will be the key of the HashMap
     * @return HashMap This returns the CardMap that we need
     */
    private static HashMap<CardRank, Integer>
    getCardMap(ArrayList<CardRank> ranks){
        HashMap<CardRank, Integer> CardMap = new HashMap<>();
        //for every rank in ranks, put this rank into the key
        // and put its frequency into the value
        for(CardRank r :ranks) {
            if (CardMap.containsKey(r)){
                CardMap.put(r, CardMap.get(r) + 1);
            }else{
                CardMap.put(r,1);
            }
        }
        return CardMap;
    }

    /**
     * This method is used to get the key from value, in other words, we can
     * use this method to get the ranks of card when we input there occurrence
     * it's a many to one mapping
     * @param CardMap the HashMap we input
     * @param value the certain value(frequency) we input to find the
     *              corresponding ranks
     * @return return the ArrayList which stores all suitable keys
     */
    private static ArrayList<CardRank>
    getKeysByValue(HashMap<CardRank, Integer> CardMap, Integer value){
        ArrayList<CardRank> key = new ArrayList<>();
        ArrayList<CardRank> sortedKeys = new ArrayList<>(CardMap.keySet());
        Collections.sort(sortedKeys);
        //iterate over entries to pick all suitable keys and store them in
        // the key ArrayList
        for (CardRank k : sortedKeys) {
            if (CardMap.get(k) == value){
                key.add(k);
            }
        }
        return key;
    }

    /**
     * This method is used to check whether the five cards are of the same suit
     * @param suits This is the ArrayList which stores the suits of cards
     * @return return false if there are two cards have different suits
     */
    private static boolean flush(ArrayList<CardSuit> suits) {
        //this for loop traverse the suits in order to check if there
        // are two cards of different suits
        for (int i = 1; i < suits.size(); i++) {
            if (suits.get(i) != suits.get(i -1)){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to check whether these five cards form a sequence,
     * it is similar to the flush method, ranks are sorted in Poker class
     * @param ranks
     * @return
     */
    private static boolean straight(ArrayList<CardRank> ranks){
        for (int i = 1; i < ranks.size(); i++){
            int rank1 = ranks.get(i - 1).ordinal();
            int rank2 = ranks.get(i).ordinal();

            if (rank2 != rank1 + 1){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is the core of this class, used for classification
     */
    public void CheckHands(){
        HashMap<CardRank, Integer> CardMap = getCardMap(ranks);
        ArrayList<Integer> MapValues = new ArrayList<>(CardMap.values());
        //sort MapValues in descending order, so that we can use
        // MapValues.get(0) to get the largest appear time and so on
        Collections.sort(MapValues, Collections.reverseOrder());
        System.out.print("Player 1: ");


        //Straight flush
        if (flush(suits) && straight(ranks)){
            System.out.println(ranks.get(ranks.size()-1).getName()
                    + "-high straight flush");
            return;
        }

        //Four of a kind
        if (MapValues.get(0) == 4){
            CardRank rank4 = getKeysByValue(CardMap, 4).get(0);
            System.out.println("Four " + rank4.getName() + "s");
            return;
        }

        //full house
        if (MapValues.get(0) == 3 && MapValues.get(1) == 2){
            CardRank rank3 = getKeysByValue(CardMap, 3).get(0);
            CardRank rank2 = getKeysByValue(CardMap,2).get(0);
            System.out.println(rank3.getName() + "s full of "
                    + rank2.getName()+"s");
            return;
        }

        //Flush (not straight)
        if (flush(suits) && !straight(ranks)) {
            System.out.println(ranks.get(ranks.size() - 1).getName()
                    + "-high flush");
            return;
        }

        //Straight (not flush)
        if (straight(ranks) && !flush(suits)){
            System.out.println(ranks.get(ranks.size() - 1).getName()
                    + "-high straight");
            return;
        }

        //Three of a kind (not full house)
        if (MapValues.get(0) == 3 && MapValues.get(1) != 2){
            CardRank rank3 = getKeysByValue(CardMap, 3).get(0);
            System.out.println("Three " + rank3.getName() + "s");
            return;
        }

        //Two Pair
        if (MapValues.get(0) == 2 && MapValues.get(1) == 2){
            CardRank rank21 = getKeysByValue(CardMap,2).get(0);
            CardRank rank22 = getKeysByValue(CardMap, 2).get(1);
            System.out.println(rank22.getName() + "s over "
                    + rank21.getName() + "s" );
            return;

        }

        //One pair (only one)
        if (MapValues.get(0) == 2 && MapValues.get(1) == 1){
            CardRank rank2 = getKeysByValue(CardMap, 2).get(0);
            System.out.println("Pair of " + rank2.getName()+ "s");
            return;
        }

        //High Card (not flush)
        if (MapValues.get(0) == 1 && !flush(suits)){
            System.out.println(ranks.get(ranks.size() - 1).getName() + "-high");
            return;
        }
    }

}
