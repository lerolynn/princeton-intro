public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }
    }
}

