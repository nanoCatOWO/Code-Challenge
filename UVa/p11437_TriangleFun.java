// p11437_TriangleFun
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

class p11437_TriangleFun{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    DecimalFormat df = new DecimalFormat("0");

    double distance(Point a, Point b) {
        double x1 = a.x, y1 = a.y, x2 = b.x, y2 = b.y;
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    Point thirdPoint(Point u,Point v) {
        double x = (u.x-v.x)/3.0+v.x;
        double y = (u.y-v.y)/3.0+v.y;
        return new Point(x, y);
    }

    Point find(Point x1,Point y1,Point x2,Point y2) {
        double A1 = y1.y-x1.y , B1 = x1.x-y1.x , C1 = A1*x1.x+B1*x1.y ;
        double A2 = y2.y-x2.y , B2 = x2.x-y2.x , C2 = A2*x2.x+B2*x2.y ;
        double det = A1*B2 - A2*B1 ;
        double x = (B2*C1-B1*C2)/det ;
        double y = (A1*C2-A2*C1)/det ;
        return new Point(x, y) ;
    }

    double area(Point A , Point B , Point C) {
        return Math.abs(A.x*(B.y-C.y) + B.x*(C.y-A.y) + C.x*(A.y-B.y))/2.0 ;
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

    double computeArea(Point A, Point B, Point C) {
        Point D, E, F, P, Q, R;
        D = thirdPoint(C, B);
        E = thirdPoint(A, C);
        F = thirdPoint(B, A);
        P = find(A, D, B, E);
        Q = find(C, F, B, E);
        R = find(A, D, C, F);        
        return area(P,Q,R);
    }

    public void read() {        
        try {
            int N = Integer.parseInt(in.readLine());
            Point A, B, C;
            while(N-- > 0) {
                st = new StringTokenizer(in.readLine());
                A = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                B = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                C = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                out.println(df.format(computeArea(A, B, C)));
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p11437_TriangleFun().read();
    }
}