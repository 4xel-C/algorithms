import utils.Helper;

public class ShellSort {

    // Java implementation of the Shell Sort Algorithm on an integer array using Knuth sequence (gap = 3 * gap + 1)
    // time complexity:
    // Best case: O(nlogn)
    // Average: O(n^1.5) to O(n^2)
    // Worst: O(n²)

    	public static void shellSort(int[] array) {
		
		int len = array.length;
		
		// initialization of the gap
		int gap = 0;
		
		// set up the gap
		while (gap < len-1) {
			gap = (3 * gap) + 1;
		}
		

		while (gap >= 1) {
			
			for (int i = gap; i < len; i++) {
				int j = i;
				int key = array[i];  // element to sort
				
				while (j >= gap && array[j - gap] > key)  {
					array[j] = array[j - gap];
					j -= gap;
				}
				
				array[j] = key;
			}
			
			// reduction of gap
			gap /= 3;
		}
	}

    public static void main(String[] args){
        
        // Testing selection sort algorithm
        int[] array = {1, 2, 6, 5, 3, 9, 98, 34, 3};

        Helper.printArray(array);
        shellSort(array);
        Helper.printArray(array);
    
    }
}
