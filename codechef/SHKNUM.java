import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

class SHKNUM {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    long abs(long a) {
        return a < 0 ? (-1)*a: a;
    }

    long min(long a, long b) {
        return a > b ? b : a;
    }

    long[] twosPows() {
        long[] twosPows = new long[31];
        twosPows[0] = 1;
        for(int pow = 1; pow < 31; pow++) {
            twosPows[pow] = 2 * twosPows[pow-1]; 
        }
        return twosPows;
    }

    long minimumOperationsNumber(long N) {
        long minimum = 1000000001, M;
        int x, y;
        for (x = 0; x < 31; x++) {
            for(y = x+1; y < 31; y++) {
                M = twosPows[x] + twosPows[y];
                minimum = min(abs(M-N), minimum);
            }
        }
        return minimum;
    }

    // long minimumOperationsNumber(int N) {
    //     long minimum = 1000000001, M;
    //     int x, y;
    //     for (x = 0; x < 31; x++) {
    //         for(y = x+1; y < 15; y++) {
    //             M = (long)Math.pow(2, x) + (long)Math.pow(2, y);
    //             minimum = min(abs(M-N), minimum);
    //         }
    //     }
    //     return minimum;
    // }
    long[] twosPows = twosPows();
    public void read() {
        try {
            int T = Integer.parseInt(in.readLine());
            long N;
            while( T-- > 0) {
                N = Long.parseLong(in.readLine());
                out.println(minimumOperationsNumber(N));
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new SHKNUM().read();
    }
}