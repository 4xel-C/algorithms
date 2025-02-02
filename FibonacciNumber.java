import utils.Helper;

public class FibonacciNumber {

    // Implementation of the Fibonacci problem: trying to find all path for 0 to N using 1 or 2 jumps.
    // ex for N = 3: {0-1-2-3}, {0-2-3}, {0-1-3}.


    /* 
     *By using the recursive method, we start from the end and we cascade until we hit one of the base cases
     *Complexity used by this method is O(2^n) and may be ineficient for high n=50 took approx 25 seconds.
     */
    static int jumpPathsRecursive(int n) {

        // base cases:
        if (n == 1){

            // Only 1 possibility to be at 1 from 0
            return 1;
        }

        else if (n == 2){

            // 2 possibilities to go to 2 from 0
            return 2;
        }

        // Each 'n' can be reached from n-1 and n-2 paths
        int paths = jumpPathsRecursive(n-1) + jumpPathsRecursive(n-2);

        return paths;
    }
    
    /*
     * Using Dynamic programming, we can reach a O(n) complexity, but we also avec a O(n) memory compexity as we store all the values from 0 in an array of n+1 size.
     * This method Calculate the Fibonacci sequence by counting step by step from 0 all the paths up to n. Using numPath(x) = numPath(x-1) + numPath(x-2)
     */
    static int jumpPathsDynamic(int n){

        // Initialise an array that will progressvily keep track of the number of path from 0 to n numbers
        int[] countPaths = new int[n+1];

        // Initialize the first 2 numbers with countPaths[0] = 0 to match the index of the array with n.
        countPaths[0] = 0;
        countPaths[1] = 1;
        countPaths[2] = 2;

        for (int i = 3; i <= n; i++) {
            countPaths[i] = countPaths[i-1] + countPaths[i-2];
        }
        return countPaths[n];
    }

    /*
     * Dynamic programming (same logic used in jumpPathsDynamic), but with optimized space by using only 2 variables that update overtime
     */
    static int jumpPathsDynamicOptimized(int n){
        
        int previousValue = 1;
        int result = 2;
        int temp;

            for (int i = 3; i <= n; i++) {
                temp = result;
                result = result + previousValue;
                previousValue = temp;
            }
        return result;
    }

    public static void main(String[] args){

        // testing part 
        // n to calculate
        int n = 45;

        System.out.println("Recursive method:");
        System.out.println(Helper.timer(() -> jumpPathsRecursive(n)));
        System.out.println();

        System.out.println("Dynamic programming method:");
        System.out.println(Helper.timer(() -> jumpPathsDynamic(n)));
        System.out.println();

        System.out.println("Dynamic programming method Optimized:");
        System.out.println(Helper.timer(() -> jumpPathsDynamicOptimized(n)));
        System.out.println();
    }
}