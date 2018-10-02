import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

class p10522_HeightToArea{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    DecimalFormat df = new DecimalFormat("0.000");

    boolean canBuildATriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    double area(double ha, double hb, double hc) {
        double a = (1/ha), b = (1/hb), c = (1/hc);        
        return Math.sqrt(1/((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c)));
    }

    public void read() {        
        try {
            int invalidInputs = Integer.parseInt(in.readLine());
            while(invalidInputs > 0) {
                st = new StringTokenizer(in.readLine());
                double ha, hb, hc;
                Double area;
                ha = Double.parseDouble(st.nextToken());
                hb = Double.parseDouble(st.nextToken());
                hc = Double.parseDouble(st.nextToken());
                if(ha == 0.0 && hb == 0.0 && hc == 0.0) {
                    out.println("These are invalid inputs!");
                    invalidInputs--;
                } else {
                    area = area(ha, hb, hc);  
                    if( area.isNaN() || area < 1e-9 || area.isInfinite()) {
                        out.println("These are invalid inputs!");
                        invalidInputs--;
                    } else {
                        out.println(df.format(area));
                    }                    
                }
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p10522_HeightToArea().read();
    }
}