public class ColorHSB {

    private final int hue, sat, bri;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException("the hue must be between 0 and 359");
        else hue = h;

        if (s < 0 || s > 100) throw new IllegalArgumentException("the saturation must be between 0 and 100");
        else sat = s;

        if (b < 0 || b > 100) throw new IllegalArgumentException("the brightness must be between 0 and 100");
        else bri = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bri + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return hue == 0 || sat == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        return (int) Math.round(Math.min(Math.pow(that.hue - hue, 2),
                Math.pow(360 - Math.abs(that.hue - hue), 2)) +
                Math.pow(that.sat - sat, 2) +
                Math.pow(that.bri - bri, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB refColor = new ColorHSB(h, s, b);
        ColorHSB closestColor = new ColorHSB(0, 0, 0);
        String closestName = "Black";
        int closestDist = 999;


        while (!StdIn.isEmpty()) {
            String col = StdIn.readString();
            int hue = StdIn.readInt();
            int sat = StdIn.readInt();
            int bri = StdIn.readInt();

            ColorHSB nextColor = new ColorHSB(hue, sat, bri);
            int distToRef = nextColor.distanceSquaredTo(refColor);
            if (distToRef < closestDist) {
                closestColor = nextColor;
                closestName = col;
                closestDist = distToRef;

            }
        }
        StdOut.println(closestName + " " + closestColor.toString());

    }

}
