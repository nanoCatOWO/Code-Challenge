import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.awt.geom.Line2D;

class p11343_IsolatedSegments{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;

    int countIntersections(Line2D[]segments) {
        int inters = 0, ia, ib;
        Line2D a,b;
        boolean[] intersected = new boolean[segments.length];
        for(ia = 0; ia < segments.length; ia++) {
            a = segments[ia];
            for(ib = 0; ib < segments.length; ib++) {
                    if(ib!=ia) {
                        b = segments[ib];
                        if(a.intersectsLine(b)) {
                            intersected[ib] = true;
                            intersected[ia] = true;
                        }
                    }
                }
        }

        for(boolean i: intersected) {
            if(!i) {
                inters++;
            }
        }
        return inters;
    }  

    public void read() {        
        try {
            int N = Integer.parseInt(in.readLine()),ns;
            int x,y,u,v;
            while(N-- > 0) {
                ns = Integer.parseInt(in.readLine());
                Line2D[] segments = new Line2D[ns];
                for(int is = 0; is < ns; is++) {
                    st = new StringTokenizer(in.readLine());
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    u = Integer.parseInt(st.nextToken());
                    v = Integer.parseInt(st.nextToken());
                    segments[is] = new Line2D.Double(x, y, u, v);
                }
                out.println(countIntersections(segments));
            }
        } catch(Exception e) {
            out.println(e.getMessage() + " Error");
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p11343_IsolatedSegments().read();
    }
}