import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

class p10210_RomeoAndJuliet{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    DecimalFormat df = new DecimalFormat("0.000");

    double distance(Point a, Point b) {
        double x1 = a.x, y1 = a.y, x2 = b.x, y2 = b.y;
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    class Point {
        double x,y;

        public Point(double x, double y) {
            this.x = x; this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }

    public void read() {        
        try {
            String line;
            Point A, B;             
            double CMD, ENF, alpha, betha, right, left, AB;
            while((line = in.readLine()) != null) {
                st = new StringTokenizer(line);
                A = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                B = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                CMD = Double.parseDouble(st.nextToken());
                ENF = Double.parseDouble(st.nextToken());
                alpha = Math.PI*CMD/180.0; betha = Math.PI*ENF/180.0;
                AB = distance(A, B);
                right = AB/Math.tan(alpha);
                left = AB/Math.tan(betha);
                out.println(df.format(right+left));
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p10210_RomeoAndJuliet().read();
    }
}