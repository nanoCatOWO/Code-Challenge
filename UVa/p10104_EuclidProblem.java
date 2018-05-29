//p10104_EuclidProblem
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

class p10104_EuclidProblem{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    DecimalFormat df = new DecimalFormat("0.000");

    double dot(Vector a, Vector b) { 
        return (a.x * b.x + a.y * b.y); 
    }

    double norm_sq(Vector v) { 
        return v.x * v.x + v.y * v.y; 
    }

    Vector toVector(Point a, Point b) {
        return new Vector(b.x - a.x, b.y - a.y);
    }

    double cross(Point o, Point a, Point b) {
        return (a.x - o.x)*(b.y-o.y) - (a.y - o.y)*(b.x - o.x);
    }

    double distance(Point a, Point b) {
        double x1 = a.x, y1 = a.y, x2 = b.x, y2 = b.y;
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    double angle(Point a, Point o, Point b) {
        Vector oa = toVector(o, a), ob = toVector(o, b);
        return Math.acos(dot(oa, ob)) / Math.sqrt(norm_sq(oa)*norm_sq(ob));
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

    class Vector {
        double x, y;

        public Vector(double x, double y) {
            this.x = x; this.y = y;
        }
    }    

    Point[] getPoints(Point[]ps) {
        Point[] extra = new Point[2];
        double areaDEF = (Math.abs(cross(ps[3], ps[4], ps[5])))/2;
        double areaABC = (Math.abs(cross(ps[0], ps[1], ps[2])));
        double _AB_,_AC_,_BG_,sinotheta;
        _AB_ = distance(ps[0], ps[1]);
        _AC_ = distance(ps[0], ps[2]);
        sinotheta = areaABC/(_AB_*_AC_);
        _BG_ = areaDEF/(sinotheta*_AB_);
        extra[1] = new Point(0,0); extra[0] = new Point(0, 0);
        extra[1].x = ps[0].x + (ps[2].x-ps[0].x)*_BG_/_AC_;
        extra[1].y = ps[0].y + (ps[2].y-ps[0].y)*_BG_/_AC_;
        extra[0].x = extra[1].x + (ps[1].x - ps[0].x);
        extra[0].y = extra[1].y + (ps[1].y - ps[0].y);
        return extra;
    }

    public void read() {
        try {
            StringTokenizer st;
            String line;
            boolean finished = false;
            Point[]ps;            
            while(!finished) {
                line = in.readLine().trim();
                if(line.equals("0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0")){
                    finished = true; 
                } else {
                    st = new StringTokenizer(line);
                    ps = new Point[6];
                    for(int ip = 0; ip < 6; ip++) {
                        ps[ip] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));                    
                    }
                    Point[]ans = getPoints(ps);
                    Point H = ans[1],G = ans[0];
                    out.println(df.format(G.x)+" "+df.format(G.y)+" "+df.format(H.x)+" "+df.format(H.y));
                }
            }
        } catch(Exception e) {
            out.println(e.getMessage() + " Error");
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p10104_EuclidProblem().read();
    }
}
