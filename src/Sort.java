import java.util.*;

public class Sort {

    /**
     * Bubble Sort is a sorting algorithm that swaps two elements next to each other if they are out of order as our
     * index is increasing, until the whole list is sorted.
     * Here we are sorting the given list in place.
     * Time: O(n^2) at its worst. O(n) for iterating, and another O(n - 1) or O(n) for comparisons
     * Space:
     * @param list A list of numbers
     * @return A sorted list of number
     */
    public int[] bubbleSort(int[] list) {
        boolean isSorted = false;
        for (int pass = 0; pass < list.length; pass++) {
            isSorted = true;
            for (int i = 1; i < list.length - pass; i++) // note the i = 1
                if (list[i] < list[i - 1]) {
                    swap(list, i, i - 1);
                    isSorted = false;
                }
            if (isSorted)
                return list;
        }
        return list;
    }

    /**
     * I saw someone on YouTube dong this and I thought that this was a really good idea.
     * Whatever list we pass, it will swap the elements in that list in place... pretty cool.
     * @param list A List that we're swapping elements in.
     * @param index1 Position of the first element that we're swapping.
     * @param index2 Position of the second element that we're swapping.
     */
    private void swap(int[] list, int index1, int index2) {
        int temp = list[index1]; // hold my beer so that I don't lose it
        list[index1] = list[index2];
        list[index2] = temp;
    }

    /**
     * Bogo Sort is sorting algorithm that (tries) to sort a list by shuffling the contents of a list. As long as the
     * list is not sorting, the algorithm will keep shuffling, and shuffling, and shuffling, etc.
     * @param list
     * @return
     */
    public int[] bogoSort(int[] list) {
        if (isSorted(list)) return list;
        while (!isSorted(list))
            list = shuffleList(list);

        return list;
    }
    private int[] shuffleList(int[] list) {
        int[] newList = new int[list.length];
        Stack<Integer> visitedIndex = new Stack<>();

        for (int i = 0; i < list.length; i++) {
            int randomIndex = new Random().nextInt(list.length);
            if (!visitedIndex.contains(randomIndex)) {
                newList[i] = list[randomIndex];
                visitedIndex.add(randomIndex);
            } else {
                i--;
            }
        }
        return newList;
    }
    private boolean isSorted(int[] list) {
        // length - 1 in loop because we're checking current to next item.
        // we would get index out of bounds without this
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] > list[i + 1])
                return false;
        return true;
    }

    /**
     * Merge Sort is a sorting algorithm that uses Divide and Conquer methodology to sort lists. The idea is that
     * problems can be solved better if they are broken down into smaller problems. Merge Sort first keeps dividing
     * the given list until the list is broken down into smaller lists. It keeps doing this until each list has just
     * one element. Then, we (conquer) merge. As we're merging, we're comparing and sorting items from list A to list B.
     * Time: O(n log n) because merge sort splits the lists and sequentially (linear time) merges them
     * Space: O(n) beause even though we're splitting the arrays, those arrays are not going to be larger than the original. Hence, at it's worst, O(n)
     * @param list an integers array
     * @return a sorted list.
     */
    public int[] mergeSort(int[] list) {
        if (list.length <=1 ) {
            return list;
        }
        int[][] leftRightArr = split(list);
        int[] left = mergeSort(leftRightArr[0]);
        int[] right = mergeSort(leftRightArr[1]);
        return merge(left, right);
    }
    private int[][] split(int[] list) { // EX: len = 9
        int midpoint = list.length / 2; //     9 / 2 = 4
        int[] left = new int[midpoint]; //     len = 4
        int[] right = new int[list.length - midpoint]; // 9 - 4 = 5. len = 5

        for (int i = 0; i < midpoint; i++) {
            left[i] = list[i];
        }
        for (int i = midpoint; i < list.length; i++) {
            right[i - midpoint] = list[i];
        }
        return new int[][] { left, right };
    }
    private int[] merge(int[] left, int[] right) {
        // i = left, j = right, k = index for sortedArray
        int i = 0, j = 0, k = 0;
        int[] sortedArr = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sortedArr[k] = left[i];
                i++;
            } else {
                sortedArr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            sortedArr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            sortedArr[k] = right[j];
            j++;
            k++;
        }

        return sortedArr;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) return list;

        List<List<Integer>> splitArr = split(list);
        List<Integer> left = mergeSort(splitArr.get(0));
        List<Integer> right = mergeSort(splitArr.get(1));
        return merge(left, right);
    }
    private List<List<Integer>> split(List<Integer> list) {
        List<List<Integer>> newList = new ArrayList<>();
        int mid = list.size() / 2;

        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());

//        for (int i = 0; i < mid; i++) {
//            left.add(list.get(i));
//        }
//        for (int i = mid; i < list.size(); i++) {
//            right.add(list.get(i));
//        }

        newList.add(left);
        newList.add(right);
        return newList;
    }
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0;
        List<Integer> sortedArr = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                sortedArr.add(left.get(i));
                i++;
            } else {
                sortedArr.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            sortedArr.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            sortedArr.add(right.get(j));
            j++;
        }

        return sortedArr;
    }

}
