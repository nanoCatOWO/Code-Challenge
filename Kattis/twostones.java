import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class twostones {

    void read() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int N = Integer.parseInt(in.readLine());
            if (N%2 != 0) {
                out.println("Alice");
            } else {
                out.println("Bob");
            }
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new twostones().read();
    }
}