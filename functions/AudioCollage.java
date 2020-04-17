public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amplified = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amplified[i] = a[i] * alpha;
        }
        return amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] rev = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            rev[i] = a[a.length - 1 - i];
        }
        return rev;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[i + a.length] = b[i];
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if (a.length >= b.length) {
            double[] mixed = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                mixed[i] = a[i];
            }
            for (int i = 0; i < b.length; i++) {
                mixed[i] += b[i];
            }
            return mixed;
        } else {
            double[] mixed = new double[b.length];
            for (int i = 0; i < b.length; i++) {
                mixed[i] = b[i];
            }
            for (int i = 0; i < a.length; i++) {
                mixed[i] += a[i];
            }
            return mixed;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int originalSpeed = a.length;
        int newSpeed = (int) (originalSpeed / alpha);
        double[] newSound = new double[newSpeed];
        for (int i = 0; i < newSpeed; i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] singer = StdAudio.read("singer.wav");
        StdAudio.play(merge(merge(chimes, mix(amplify(cow, 0.8), piano)), merge(changeSpeed(mix(harp, reverse(piano)), 1.0), singer)));
    }
}
