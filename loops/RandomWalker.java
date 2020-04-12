public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int dist = 0;
        int x = 0;
        int y = 0;
        int direction;
        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
