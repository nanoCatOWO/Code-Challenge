import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class quadrant {

    int numberOfQuadrant(int x, int y) {
        int quadrant = 1;
        quadrant = x > 0 ? ( y > 0 ? 1: 4) : ( y > 0 ? 2: 3 ); 
        return quadrant;
    }

    void read() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int x,y;
            x = Integer.parseInt(in.readLine());
            y = Integer.parseInt(in.readLine());
            out.println(numberOfQuadrant(x, y));
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new quadrant().read();
    }
}