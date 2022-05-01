public class Search {
    /**
     * Sequantially search for [target].
     * O(n), where n is the length of the list
     * @param list Array of numbers.
     * @param target Number that is being looked for.
     * @return Index of the postion of the target. If the target does not exist in the array, -1 is returned.
     */
    public int linearSearch(int[] list, int target) {
        if (list.length == 1 && list[0] == target) return 0; // best case O(1), no searching

        for (int i = 0; i < list.length; i++) {
            // Worst case O(n)
            if (list[i] == target) return i;
        }
        return -1;
    }
    public int binarySearch(int[] list, int target) {
        if (list.length == 1 && list[0] != target) return -1;
        int mid = list.length / 2;
        if (list[mid] == target) return mid;
        else if (list[mid] > target) {
            int[] newList = new int[mid];
            for (int i = 0; i < mid; i++) newList[i] = list[i];
            return binarySearch(newList, target);
        }
        else {
            int[] newList = new int[list.length - mid];
            for (int i = mid; i < list.length; i++) newList[i - mid] = list[i];
            return binarySearch(newList, target);
        }
    }
}
