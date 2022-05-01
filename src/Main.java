import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        Search search = new Search();

        // get 100 random numbers between 0 and 100
        int[] nums = sort.mergeSort(randomNumbers(100, 101));
        // look for target in the list
        int target = 1;

        // code here...

    }
    
    /**
     * A simple method that provides random numbers.
     * @param amount how many numbers do you want?
     * @param bound the upper bound (but not including) of each number.
     * @return an array of ints of given length.
     */
    private static int[] randomNumbers(int amount, int bound) {
        Random rand = new Random();
        int[] randomNumbers = new int[amount];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(bound);
        }
        return randomNumbers;
    }
    public static void log(Object ... anything) {
        for (Object something : anything) {
            System.out.println(something);
        }
    }
}