public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        // Number of inversions
        long inv = k;
        // Length of array to swap
        int len = n - 1;
        while (inv != 0) {
            // If number of inversions > length of unswapped array
            if (inv >= len) {
                int temp = permutation[n - 1];
                for (int i = n - 2; i >= n - 1 - len; i--) {
                    permutation[i + 1] = permutation[i];
                }

                permutation[n - 1 - len] = temp;
                inv -= len;
                len--;

            } else {
                int temp = permutation[n - 1];
                for (int i = n - 2; i >= n - 1 - inv; i--) {
                    permutation[i + 1] = permutation[i];
                }

                permutation[n - 1 - (int) inv] = temp;
                inv -= inv;

            }
        }
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] generated = generate(n, k);

        for (int i = 0; i < generated.length; i++) {
            StdOut.print(generated[i] + " ");
        }
        StdOut.println();
    }
}
