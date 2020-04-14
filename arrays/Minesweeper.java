public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] cells = new boolean[m + 2][n + 2];

        // Place k number of mines on grid randomly
        for (int i = 0; i < k; i++) {
            int mIndex = (int) (Math.random() * (m) + 1);
            int nIndex = (int) (Math.random() * (n) + 1);
            // Check that mine is not placed in a location twice
            while (cells[mIndex][nIndex]) {
                mIndex = (int) (Math.random() * (m) + 1);
                nIndex = (int) (Math.random() * (n) + 1);
            }
            cells[mIndex][nIndex] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (cells[i][j]) {
                    System.out.print("*  ");
                } else {
                    int mineCount = 0;
                    if (cells[i - 1][j - 1]) {
                        mineCount++;
                    }
                    if (cells[i - 1][j]) {
                        mineCount++;
                    }
                    if (cells[i - 1][j + 1]) {
                        mineCount++;
                    }
                    if (cells[i][j - 1]) {
                        mineCount++;
                    }
                    if (cells[i][j + 1]) {
                        mineCount++;
                    }
                    if (cells[i + 1][j - 1]) {
                        mineCount++;
                    }
                    if (cells[i + 1][j]) {
                        mineCount++;
                    }
                    if (cells[i + 1][j + 1]) {
                        mineCount++;
                    }

                    System.out.print(mineCount + "  ");
                }


            }
            System.out.println();
        }

    }
}
