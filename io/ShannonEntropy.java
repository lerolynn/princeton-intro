public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double h = 0.0;
        int total = 0;
        int[] x = new int[m];
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            x[p - 1]++;
            total++;
        }

        for (int i = 0; i < m; i++) {
            if (x[i] != 0) {
                h += -((double) x[i] / total) * (Math.log((double) x[i] / total) / Math.log(2));
            }
        }
        StdOut.printf("%.4f\n", h);

    }
}
