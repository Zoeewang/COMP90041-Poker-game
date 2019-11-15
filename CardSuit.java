
/**

 * This enum class is used to define the suit collection of pokers, it
 * contains 4 suits
 */
public enum CardSuit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String character;
    //Constructor
    CardSuit(String character) {
        this.character = character;
    }
    //Accessor
    public String getCharacter() {
        return character;
    }

    /**
     * It is similar to the fromString method in CardRank
     * @param character
     * @return
     */
    public static CardSuit fromString(String character){
        for (CardSuit s : CardSuit.values()){
            if (s.character.equalsIgnoreCase(character)){
                return s;
            }
        }
        return null;
    }
}
