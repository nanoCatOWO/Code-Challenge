import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

class SPELLBOB {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    boolean containsBobsCharacters(String word) {
        return word.equals("bob") || word.equals("obb") || word.equals("bbo");
    }

    String isPossibleSpellBob(char[][]cards) {
        boolean isPossible = false;
        int a, b, c;
        for (a = 0; a < 2; a++) {
            for (b = 0; b < 2; b++) {
                for (c = 0; c < 2; c++) {
                    isPossible |= containsBobsCharacters(cards[a][0] + "" + cards[b][1] + "" + cards[c][2]);
                }
            }
        }
        return isPossible ? "yes" : "no";
    }

    public void read() {
        try {
            int T = Integer.parseInt(in.readLine());
            char[][]cards;
            while (T-- > 0) {
                cards = new char[2][];
                cards[0] = in.readLine().toCharArray();
                cards[1] = in.readLine().toCharArray();
                out.println(isPossibleSpellBob(cards));
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new SPELLBOB().read();
    }
}