public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n];
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) s[i] = 0;
            else s[i] = a[i - 1] + s[i - 1];
        }
        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * (s[n]));
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (s[i - 1] <= r && s[i] > r) index = i;
            }
            System.out.print(index + " ");
        }
        System.out.println();
    }
}
