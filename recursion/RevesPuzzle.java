public class RevesPuzzle {

    private static void hanoi(int n, int k, char source, char dest, char extra) {
        if (n == k) return;
        if (n == k + 1) {
            System.out.println("Move disc " + n + " from " + source + " to " + dest);
            return;
        }
        hanoi(n - 1, k, source, extra, dest);
        System.out.println("Move disc " + n + " from " + source + " to " + dest);
        hanoi(n - 1, k, extra, dest, source);

    }

    public static void reves(int n, char A, char B, char C, char D) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + A + " to " + D);
            return;
        }
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));

        reves(k, A, D, C, B);
        hanoi(n, k, A, C, D);
        reves(k, B, A, C, D);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 'A', 'B', 'C', 'D');
        System.out.println();
    }
}



