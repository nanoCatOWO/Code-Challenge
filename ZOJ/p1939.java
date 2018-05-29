import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashSet;
//
// x a c b e f z
// y l m  m l l a z e f
// 
// a c b e f z
// a z 0 1
// 
// a z c b e f z
// a e z f 
class p1939 {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    class Computer {

        public String buildSequence(int[][]indexs, String[] tokens) {
            String seq = "";
            int i = indexs.length-1, j = indexs[0].length-1;
            while(i != 0 && j != 0) {
                // out.println(i+"..."+j);
                if(indexs[i][j] == 1) {
                    seq = tokens[i-1] + " " + seq;
                    i -= 1; j -= 1;
                } else if(indexs[i][j] == 2) { 
                    i -= 1; 
                } else {
                    j -= 1;
                }
            }
            // out.println("endddd");
            return seq.trim();
        }

        public String logestCommonSubsWords(String sa, String sb) {
            String longest = "", b;
            String[] tokensA = sa.split(" "), tokensB = sb.split(" ");
            int[][] memo = new int[tokensA.length+1][tokensB.length+1];
            int[][] indexs = new int[tokensA.length+1][tokensB.length+1];
            indexs[0][0] = -1;
            for(int ia = 1; ia <= tokensA.length; ia++) {
                for(int ib = 1; ib <= tokensB.length; ib++) {
                    if(tokensA[ia-1].equals(tokensB[ib-1])) {
                        memo[ia][ib] = memo[ia-1][ib-1] + 1;
                        indexs[ia][ib] = 1;
                    } else if(memo[ia-1][ib] > memo[ia][ib-1]) {
                        memo[ia][ib] = memo[ia-1][ib];
                        indexs[ia][ib] = 2;
                    } else {
                        memo[ia][ib] = memo[ia][ib-1];
                        indexs[ia][ib] = 3;
                    }
                }
            }
            return buildSequence(indexs, tokensA);
        }
    }

    String readLines() {
        String line = "",lines = "";
        try {
            while(!(line = in.readLine()).equals("#")){
                lines += " " + line;
            }
        }catch(Exception e) {
            out.println(e.getMessage());
        }
        return lines + " ";
    }

    public void read() {
        try {
            String line,textA,textB;
            Computer computer = new Computer();
            while((line = in.readLine()) != null && !(line.equals("end"))) {
                textA = textB = "";
                textA += line + readLines();
                textB += readLines();
                textA = textA.trim();
                textB = textB.trim();
                out.println(computer.logestCommonSubsWords(textA, textB));
            }
        }catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p1939().read();
    }
}