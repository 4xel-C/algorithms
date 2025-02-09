public class LinearSearch{

    /*
     * Linear serach algorithm. 
     * Param: int[] (array of integer); n -> number searched.
     * Return value: the index of the searched item. Return -1 if no item was found
     * 
     * Complexity: O(n)
     */
    static int linearSearch(int[] array, int n){

        for (int i = 0; i < array.length; i++){
            if (array[i] == n){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        int[] array = {1, 4, 98, 34, 1,23 ,28, 26, 34, 385, 2, 48};
        int n = 48;

        int index = linearSearch(array, n);

        System.out.println(index);
    }
}