public class BinarySearch {
    
    // Implementation of the binarySearch algorithm to search through a sorted algorithm

    // Complexity: O(log(n))

    /** *
     * Search an element in a sorted array
     * @param array // sorted
     * @param num // number searched
     * @return // index of the number in the array, if not found, -1
    */
    static int binarySearch(int[] array, int num) {
        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int middle = (start + end) / 2;

            if (array[middle] == num) {
                return middle;
            } else if (num < array[middle]) {
                end = middle-1;
            } else if (num > array[middle]) {
                start = middle+1;
            }
        }
        // return -1 if nothing if found
        return -1;
    }

    static void printArray(int array[]) {
        int len = array.length;

        for (int i = 0; i < len; i ++){
            System.out.print(array [i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){

    // initialization of the sorted array
    int[] array = {1, 4, 5, 8, 9, 10, 14, 23, 45, 89};
    
    printArray(array);

    System.out.println(binarySearch(array, 14));

    }

}