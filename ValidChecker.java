
/**

 * This class is used to check the validity of command line arguements
 */
public class ValidChecker {
    /**
     * This method is used to check the length of input string array
     * If the length is not greater than zero or not a multiple of five,
     * it would print out the Error and exit
     * In this simpler version, if there are more than five arguements,
     * NOT UNDERTAKEN will be the output and exit
     * @param checker This is the input string array
     */
    public static void CheckValid(String[] checker) {
        if (checker.length <= 0 || checker.length % 5 != 0) {
            System.out.println("Error: wrong number of arguments; " +
                    "must be a multiple of 5");
            System.exit(0);
        } else if (checker.length > 5) {
            System.out.println("NOT UNDERTAKEN");
            System.exit(0);
        }

    }
}
