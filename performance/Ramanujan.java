public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        long i = 1;
        long j = (long) Math.floor(Math.pow(n, 1.0 / 3.0));
        long sum;
        while (i < j) {
            sum = i * i * i + j * j * j;
            if (sum > n) j -= 1;
            else if (sum < n) i += 1;
            else {
                count++;
                i++;
            }
        }
        return (count == 2);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
