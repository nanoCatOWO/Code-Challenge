import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.util.Scanner;

class p11152_ColourfulFlowers{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    DecimalFormat df = new DecimalFormat("0.000");
    Scanner sin = new Scanner(new InputStreamReader(System.in));
	
    public void read() {        
        try {
            double a, b, c, s, triangleArea, radiousOfCircumcircle, radiousOfIncircle, areaOfInnercircle, 
            sunflowers, violets, roses;
            String line;
            while((line = in.readLine()) != null) {
                st = new StringTokenizer(line);
                a = Double.parseDouble(st.nextToken());
                b = Double.parseDouble(st.nextToken());
                c = Double.parseDouble(st.nextToken());
                s = (a+b+c)/2;
                triangleArea = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                radiousOfIncircle = triangleArea/s;
                radiousOfCircumcircle = a*b*c/Math.sqrt(2*s*(b+c-a)*(c+a-b)*(a+b-c));
                areaOfInnercircle = Math.PI*radiousOfIncircle*radiousOfIncircle;
                sunflowers = ((Math.PI*radiousOfCircumcircle*radiousOfCircumcircle)-triangleArea);
                violets = (triangleArea-areaOfInnercircle);
                roses = areaOfInnercircle;
                out.printf("%.4f %.4f %.4f\n",sunflowers, violets, roses);
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p11152_ColourfulFlowers().read();
    }
}