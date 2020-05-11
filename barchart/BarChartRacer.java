import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {

    public static void main(String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);

        In input = new In(filename);
        String title = input.readLine();
        String xLabel = input.readLine();
        String source = input.readLine();
        input.readLine();

        BarChart chart = new BarChart(title, xLabel, source);

        while (input.hasNextLine()) {
            int n = Integer.parseInt(input.readLine());
            Bar[] bars = new Bar[n];

            String time = "";

            for (int i = 0; i < n; i++) {
                String data = input.readLine();
                String[] fields;
                fields = data.split(",");
                if (i == 0) time = fields[0];
                bars[i] = new Bar(fields[1], Integer.parseInt(fields[3]), fields[4]);
            }
            input.readLine();
            Arrays.sort(bars, Collections.reverseOrder());

            chart.reset();
            StdDraw.clear();

            for (int i = 0; i < k; i++) {
                if (i == 0) chart.setCaption(time);
                if (bars[i].getValue() != 0) {
                    chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
                }
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
