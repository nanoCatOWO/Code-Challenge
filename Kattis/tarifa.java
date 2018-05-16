import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// this problem is simple arimetic, read and read to undestand it 

class tarifa{

    public static void main(String[]arg) {
        new tarifa().solve();
    }

    public void solve() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int X = Integer.parseInt(in.readLine());
            int[]P = new int[Integer.parseInt(in.readLine())];
            for(int i = 0; i<P.length; i++) {
                P[i] = Integer.parseInt(in.readLine());
            }
            out.println(computeMegabytesAvaibles(X,P));
        }catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();        
    }

    public int computeMegabytesAvaibles(int X, int[]P) {
        int megabytes = X;
        for(int i = 0; i < P.length; i++) {
            megabytes += X - P[i];
        }
        return megabytes;
    }
}