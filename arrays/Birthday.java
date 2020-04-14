public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        boolean[] birthdays = new boolean[n];
        int totalCount = 0;
        double fraction = 0.0;

        // Loop through number of birthdays available to choose from
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < trials; j++) {
                // Reset the number of people in room to 0
                for (int k = 0; k < n; k++) {
                    birthdays[k] = false;
                }
                // i number of people enter the room
                for (int k = 0; k < i; k++) {
                    int birthday = (int) (Math.random() * (n - 1));
                    if (!birthdays[birthday]) {
                        birthdays[birthday] = true;
                    } else if (k == i - 1) {
                        // Add to count only if number is i
                        count++;
                        break;
                    } else {
                        break;
                    }
                }
            }
            totalCount += count;
            fraction = (double) totalCount / trials;
            System.out.println(i + "\t" + count + "\t" + fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
