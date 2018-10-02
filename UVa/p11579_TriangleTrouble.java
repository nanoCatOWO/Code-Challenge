import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.util.Arrays;

class p11579_TriangleTrouble{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    DecimalFormat df = new DecimalFormat("0.00");

    boolean canBuildATriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    double computeTriangleArea(double a, double b, double c) {
        double perimeter = a + b + c;
        return Math.sqrt(perimeter*(perimeter - 2*a)*(perimeter - 2*b)*(perimeter - 2*c))/4.0;
    }

    double areaPossibleTriangle(double[] sides) {
        double a, b, c, area = 0.0;
        Arrays.sort(sides);
        for(int i = sides.length-1; i > 1; i--) {
            a = sides[i]; b = sides[i-1]; c = sides[i-2];
            if(canBuildATriangle(a, b, c) && computeTriangleArea(a, b, c) > area) {
                area = computeTriangleArea(a, b, c);
            }
        }        
        return area;
    }

    public void read() {        
        try {
            int T = Integer.parseInt(in.readLine()),i;
            double[] sides;
            while(T-- > 0) {
                st = new StringTokenizer(in.readLine());
                sides = new double[Integer.parseInt(st.nextToken())];
                for(i = 0; i < sides.length; i++) {
                    sides[i] = Double.parseDouble(st.nextToken());
                }
                out.println(df.format(areaPossibleTriangle(sides)));
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p11579_TriangleTrouble().read();
    }
}