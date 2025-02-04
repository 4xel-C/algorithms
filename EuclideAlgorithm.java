public class EuclideAlgorithm{

    // Compute the PGCD of A and B using euclide algorithm
    static int PGCD(int A, int B){
        if (B == 0) {
            return A;
        }
        int PGCD = PGCD(B, A%B);

        return PGCD;
    }

    // Extended Euclide algortihm to compute the PGCD and give Bezout coefficient
    static int[] extended_euclide(int A, int B){

        if (B == 0) {
            return new int[] {A, 1, 0};
        }

        int[] result = extended_euclide(B, A%B);
        int PGCD = result[0];
        int X1 = result[1];
        int Y1 = result[2];

        // Coeficient of the n-1 level of the algorithm
        int X = Y1;
        int Y = X1 - ((A/B) * Y1);

        return new int[] {PGCD, X, Y};
    }

    public static void main(String[] args){

        int A = 132;
        int B  = 83;

        System.out.println();
        System.out.println("PGCD Calculation of " + A + " and " + B);
        System.out.print("Simple Euclide algorithm: ");
        System.out.println(PGCD(A, B));
        System.out.println();

        System.out.print("Exetended Euclide algorithm: ");
        int[] result = extended_euclide(A, B);

        System.out.println("PGCD = " + result[0]);
        System.out.println("Bezout coefficients: u=" + result[1] + " v=" + result[2]);
        System.out.println();
    }
}