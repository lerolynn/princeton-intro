public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int steps = 0;
        int dist = 0;
        int x = 0;
        int y = 0;
        int direction;
        double stepAvg = 0;
        for (int i = 1; i <= trials; i++) {
            while (dist != r) {
                direction = (int) (Math.random() * 4);
                if (direction == 0) {
                    x += 1;
                } else if (direction == 1) {
                    y += 1;
                } else if (direction == 2) {
                    x -= 1;
                } else if (direction == 3) {
                    y -= 1;
                }
                dist = Math.abs(x) + Math.abs(y);
                steps++;
            }
            stepAvg = stepAvg + (steps - stepAvg) / i;
            steps = 0;
            dist = 0;
            x = 0;
            y = 0;
        }
        System.out.println("average number of steps = " + stepAvg);
    }
}
