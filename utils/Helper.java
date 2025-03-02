package utils;
import java.util.function.Supplier;

// Package containing helper functions to use for the algorythms.

public class Helper{
    
    // Wrapper function to measure the execution time of another function and return its value.
    public static <T> T timer(Supplier<T> function){
        long startTime = System.currentTimeMillis();
        T returnValue = function.get();
        long endTime = System.currentTimeMillis();
        System.out.print("Time to run (ms): ");
        System.out.println((endTime-startTime));

        return returnValue;
    }

    public static void printArray(int array[]) {
        int len = array.length;

        for (int i = 0; i < len; i ++){
            System.out.print(array [i] + " ");
        }
        System.out.println();
    }

    // Function to facilitate the permutation between 2 elements in an array given their index.
    public static void permutation(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return;
    }


}