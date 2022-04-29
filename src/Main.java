import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] sorted = sort.mergeSort(randomNumbers(1000, 17));

        for (int num : sorted) {
            System.out.println(num);
        }
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
}