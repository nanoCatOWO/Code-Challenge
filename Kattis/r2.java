import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// it's online a equation

class r2{
    public static void main(String[]arg) {
        new r2().solve();
    }

    public void solve() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int r1,s;
            r1 = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            out.println(computeR2(r1, s));
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    int computeR2(int r1, int s) {
        return s*2 - r1;
    }
}