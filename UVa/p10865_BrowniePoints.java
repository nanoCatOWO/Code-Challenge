import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class p10865_BrowniePoints{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;

    class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x; this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }    

    public String getScores(Point[]ps) {
        Point center = ps[(ps.length/2)];
        // out.println(center);
        int stanScore = 0, ollieScore = 0;
        for(Point p: ps) {
            if(p.x > center.x && p.y > center.y || p.x < center.x && p.y < center.y) {
                stanScore++;
            }
            if(p.x < center.x && p.y > center.y || p.x > center.x && p.y < center.y) {
                ollieScore++;
            }
        }
        return stanScore + " " + ollieScore;
    }

    public void read() {        
        try {
            int N;
            boolean finished = false;
            while(!finished) {
                N = Integer.parseInt(in.readLine());
                if(N == 0) {
                    finished = true;
                } else {
                    Point[]ps;
                    ps = new Point[N];
                    for(int ip = 0; ip < N; ip++) {
                        st = new StringTokenizer(in.readLine());
                        ps[ip] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    }
                    out.println(getScores(ps));
                }
            }
        } catch(Exception e) {
            out.println(e.getMessage() + " Error");
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p10865_BrowniePoints().read();
    }
}