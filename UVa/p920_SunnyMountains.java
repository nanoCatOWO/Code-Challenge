import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Arrays;

class p920_SunnyMountains{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    DecimalFormat df = new DecimalFormat("0.00");
    
    class Point implements Comparable<Point>{
        double x, y;
        int index;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            Double d = new Double(this.x), e = new Double(o.x);
            return d.compareTo(e);
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }

    Point slope(Point a, Point b) {
        return new Point(a.y - b.y, a.x - b.x);
    }

    double distance(Point a, Point b) {
        double x1 = a.x, y1 = a.y, x2 = b.x, y2 = b.y;
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    LinkedList<Point> getSunbeams(Point[] points) {
        LinkedList<Point> list = new LinkedList<>();
        boolean delete;
        Point last, p;
        for(int i = 0; i < points.length; i++) {
            p = points[i];
            p.index = i;
            delete = true;
            while(delete) {
                if(list.isEmpty()) {
                    delete = false;
                } else {
                    last = list.peekLast();
                    if(last.y < p.y) {
                        list.pollLast();
                    } else {
                        // here atention
                        delete = false;
                    }
                }
            }
            list.offerLast(p);
        }
        return list;
    }

    double getSizeDistance(Point[] points) {
        Arrays.sort(points);
        // out.println(Arrays.toString(points));
        LinkedList<Point> pointsRed = getSunbeams(points);
        // out.println(pointsRed);
        double size = 0;
        double wx = 0, wy;
        Point w, u, v, slope;
        for(int i = 1; i < pointsRed.size(); i++) {
            u = pointsRed.get(i-1); w = pointsRed.get(i);
            wy = w.y;
            if(u.index + 1 < points.length) {
                v = points[u.index+1];
                slope = slope(u, v);
                // out.println(wy-u.y);
                // out.println(u.x-v.x);
                // out.println(u.y-v.y);
                // out.println(slope);
                // out.println("######"+u+".."+v);                
                wx = (((wy-u.y)*(u.x-v.x))+((u.y-v.y)*(u.x))) / (u.y - v.y);
            } else {
                wx = w.x;
            }
            // out.println(wx+" = wx");
            w = new Point(wx, wy);
            // out.println(distance(u, w));
            size += distance(u, w);
        }
        return size;
    }

    public void read() {
        try {
            int t = Integer.parseInt(in.readLine()), cntPoints, ip, x, y;         
            Point[]points;
            StringTokenizer st;
            while(t-- > 0){
                cntPoints = Integer.parseInt(in.readLine());
                points = new Point[cntPoints];
                for(ip = 0; ip < cntPoints; ip++) {
                    st = new StringTokenizer(in.readLine());
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    points[ip] = new Point(x, y);
                }
                out.println(df.format(getSizeDistance(points)));
            }
        } catch(Exception e) {
            out.println(e.getMessage() + " Error");
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p920_SunnyMountains().read();
    }
}