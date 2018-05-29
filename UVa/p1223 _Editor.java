import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

// aa


class p1223_Editor{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int lengthOfLongestSubstring(char[]s) {
        int longestLength = 0, length, ia, ib;
        for(ia = 0; ia < s.length; ia++) {            
            for(ib = ia + 1; ib < s.length; ib++) {
                length = 0;
                while(ib + length < s.length && s[ib+length] == s[ia + length]) {
                    length++;
                }
                if(length > longestLength) {
                    // out.println(ib+"...");
                    longestLength = length;
                }
            } 
        }
        return longestLength;
    }

    public void read() {
        try {
            int t = Integer.parseInt(in.readLine());
            char[]s;
            while(t-- > 0){
                s = in.readLine().toCharArray();
                out.println(lengthOfLongestSubstring(s));
            }
        } catch(Exception e) {
            out.println(e.getMessage() + " Error");
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p1223_Editor().read();
    }
}