public class selection_sort {

    // Java implementation of the Selection Sort Algorithm on an integer array


    static int[] selectionSort(int[] array){

        int len = array.length;
        int temp;

        for (int i = 0; i < len-1; i++){
            int indexMin = i;

            for (int j = i+1; j < len; j++){
                if (array[j] < array[indexMin]){
                    indexMin = j;
                }
                temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args){
        
        // Testing selection sort algorithm
        int[] array = {1, 2, 6, 5, 3, 9, 98, 34, 3};

        for (int i = 0; i < array.length; i++){
            System.out.println(selectionSort(array)[i]);
        }
    }
}