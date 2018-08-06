import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class timeloop {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    void entireWizard(int N) {
        for (int number = 1; number <= N; number++) {
            out.println(number + " Abracadabra");
        }
    }

    void read() {
        try {
            int N = Integer.parseInt(in.readLine());
            entireWizard(N);
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new timeloop().read();
    }
}