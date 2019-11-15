
/**

 * This enum class is used to define the rank collection of pokers, it
 * contains 13 ranks
 */
public enum CardRank {
    TWO("2","2"),
    THREE("3","3"),
    FOUR("4", "4"),
    FIVE("5", "5"),
    SIX("6", "6"),
    SEVEN("7", "7"),
    EIGHT("8", "8"),
    NINE("9", "9"),
    TEN("T", "10"),
    JACK("J", "Jack"),
    QUEEN("Q", "Queen"),
    KING("K", "King"),
    ACE("A", "Ace");

    private final String character;
    private final String name;

    //Constructor
    CardRank(String character, String name) {
        this.character = character;
        this.name = name;
    }
    //Accessor
    public String getCharacter() {
        return this.character;
    }
    public String getName() {
        return this.name;
    }

    /**
     * This method is used to get an enum value from a string value, because
     * we should handle both upper or lower case characters, Enum.valueOf()
     * is not suitable
     * @param character
     * @return
     */
    public static CardRank fromString(String character){
        for (CardRank r : CardRank.values()){
            //ignore case
            if (r.character.equalsIgnoreCase(character)){
                return r;
            }
        }
        return null;
    }


}
