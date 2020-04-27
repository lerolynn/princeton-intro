public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n <= 0) return 0;
        long[] tri = new long[2 * n + 1];
        tri[0] = 1;
        tri[1] = 1;
        tri[2] = 1;
        for (int i = 1; i < n; i++) {
            long[] temp = new long[2 * (i + 1) + 1];

            for (int j = 0; j < 2 * (i + 1) + 1; j++) {
                temp[j] = tri[j];
            }

            for (int j = 1; j <= 2 * (i + 1); j++) {
                if (j == 1) tri[j] += temp[j - 1];
                else tri[j] += (temp[j - 1] + temp[j - 2]);
            }
        }
        return tri[n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));

    }
}
