import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        int len = (int) Math.floor(weights.length / 2.0);
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = len; col < newPic.width() - len; col++) {
            for (int row = len; row < newPic.height() - len; row++) {
                double rd = 0;
                double gn = 0;
                double bl = 0;
                for (int a = 0; a < weights.length; a++) {
                    for (int b = 0; b < weights.length; b++) {
                        int xCol = col + a - len;
                        int yRow = row + b - len;
                        Color oldPix = picture.get(xCol, yRow);
                        rd += oldPix.getRed() * weights[a][b];
                        gn += oldPix.getGreen() * weights[a][b];
                        bl += oldPix.getBlue() * weights[a][b];
                    }
                }
                rd = Math.round(rd);
                gn = Math.round(gn);
                bl = Math.round(bl);

                if (rd >= 255) rd = 255;
                else if (rd <= 0) rd = 0;

                if (gn >= 255) gn = 255;
                else if (gn <= 0) gn = 0;

                if (bl >= 255) bl = 255;
                else if (bl <= 0) bl = 0;

                Color newPix = new Color((int) rd, (int) gn, (int) bl);
                newPic.set(col, row, newPix);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] gauss = {{1.0 / 16, 2.0 / 16, 1.0 / 16},
                {2.0 / 16, 4.0 / 16, 2.0 / 16},
                {1.0 / 16, 2.0 / 16, 1.0 / 16}};

        return kernel(picture, gauss);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] sharp = {{0.0, -1.0, 0.0},
                {-1.0, 5.0, -1.0},
                {0.0, -1.0, 0.0}};

        return kernel(picture, sharp);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] laplace = {{-1.0, -1.0, -1.0},
                {-1.0, 8.0, -1.0},
                {-1.0, -1.0, -1.0}};

        return kernel(picture, laplace);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] emb = {{-2.0, -1.0, -0.0},
                {-1.0, 1.0, 1.0},
                {0.0, 1.0, 2.0}};

        return kernel(picture, emb);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] blur = {{1.0 / 9, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1.0 / 9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1.0 / 9, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1.0 / 9, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1.0 / 9, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1.0 / 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1.0 / 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1.0 / 9, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9}};

        return kernel(picture, blur);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture pic = new Picture(filename);
        Picture newPic = emboss(pic);

        newPic.show();
    }

}
