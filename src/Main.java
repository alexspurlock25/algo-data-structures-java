import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] sorted = sort.mergeSort(randomNumbers());

        for (int num : sorted) {
            System.out.println(num);
        }
    }
    private static int[] randomNumbers() {
        Random rand = new Random();
        int[] randomNumbers = new int[50];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(200);
        }
        return randomNumbers;
    }
}