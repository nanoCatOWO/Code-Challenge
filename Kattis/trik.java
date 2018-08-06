import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

class trik{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public int solve(char[] borksMoves) {
        int indexCup = 1;
        for (char move: borksMoves) {
            if (move == 'A' && (indexCup == 1 || indexCup == 2)) {
                indexCup = indexCup == 1 ? 2 : 1;
            } else if (move == 'B' && (indexCup == 2 || indexCup == 3)) {
                indexCup = indexCup == 2 ? 3 : 2;
            } else if (move == 'C' && (indexCup == 1 || indexCup == 3)) {
                indexCup = indexCup == 3 ? 1 : 3;
            }
        }
        return indexCup;
    }

    public void read() {        
        try{
            char[] borksMoves = in.readLine().toCharArray();
            out.println(solve(borksMoves));
        } catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new trik().read();
    }
}