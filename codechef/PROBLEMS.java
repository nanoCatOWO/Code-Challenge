import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
/**
3 3
16 24 60
498 861 589
14 24 62
72 557 819
16 15 69
435 779 232
 */
class PROBLEMS {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static StringTokenizer st = new StringTokenizer(""), ss, sn;

    class Subtask implements Comparable<Subtask> {
        int sc, ns;
        
        Subtask(int sc, int ns) {
            this.sc = sc;
            this.ns = ns;
        }

        public int compareTo(Subtask os) {
            return sc - os.sc;
        }
    }

    int countValidIndex(Subtask[] subs) {
        int cnt = 0;
        for (int index = 1; index < subs.length; index++) {
            cnt += (subs[index-1].ns > subs[index].ns ? 1 : 0);
        }
        return cnt;
    }

    class Problem implements Comparable<Problem> {
        int i, n;
        Subtask[] subs;

        Problem(int i, Subtask[] subs) {
            this.i = i;
            this.n = 0;
            this.subs = subs;
        }

        void countValidIndex() {
            Arrays.sort(subs);
            for (int index = 1; index < subs.length; index++) {
                n += (subs[index-1].ns > subs[index].ns ? 1 : 0);
            }
        }

        public int compareTo(Problem op) {
            return n == op.n ? i - op.i : n - op.n;
        }
    }

    void solve(Problem[] ps) {
        for (Problem p : ps) {
            p.countValidIndex();
        }      
        Arrays.sort(ps);
        for (Problem problem : ps) {
            out.println(problem.i + 1);
        }  
    }

    public void read() {
        try {
            st = new StringTokenizer(in.readLine());
            int P, S;
            P = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
            Problem[] ps = new Problem[P];             
            for (int ip = 0; ip < P; ip++) {
                Subtask[] subs = new Subtask[S];
                ss = new StringTokenizer(in.readLine());
                sn = new StringTokenizer(in.readLine());
                for(int is = 0; is < S; is++) {
                    subs[is] = new Subtask(Integer.parseInt(ss.nextToken()), Integer.parseInt(sn.nextToken()));
                }
                ps[ip] = new Problem(ip, subs);
            }
            solve(ps);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new PROBLEMS().read();
    }
}
