public class Clock {

    private int hour, min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) throw new IllegalArgumentException("Hours must be between 0 and 23");
        else hour = h;

        if (m < 0 || m > 59) throw new IllegalArgumentException("Minutes must be between 00 and 59");
        else min = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.charAt(2) != ':') throw new IllegalArgumentException("Time has incorrect format");

        hour = Integer.parseInt(s.substring(0, 2));
        min = Integer.parseInt(s.substring(3, 5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d", hour) + ":" + String.format("%02d", min);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else if (hour == that.hour) {
            return min < that.min;
        } else return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        min++;
        if (min > 59) {
            min = min % 60;
            hour++;

            if (hour > 23) {
                hour = hour % 24;
            }
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        min += delta;
        if (min > 59) {
            min = min % 60;
            hour++;
            hour += (int) Math.floor(delta / 60.0);

            if (hour > 23) {
                hour = hour % 24;
            }
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c;
        if (args.length == 1) {
            String s = args[0];
            c = new Clock(s);
        } else if (args.length == 2) {
            int h = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            c = new Clock(h, m);
        } else throw new IllegalArgumentException("Wrong time input");

        Clock gottaGo = new Clock("12:00");

        c.tic();
        c.toc(701);

        System.out.println("Time is: " + c.toString());
        System.out.println(c.isEarlierThan(gottaGo));
    }
}
