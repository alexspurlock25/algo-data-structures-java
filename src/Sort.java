public class Sort {
    /**
     * Sorts given num list in asc order. Splits list into two lists recursively until there each list has only one element.
     * O notation:
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
}
