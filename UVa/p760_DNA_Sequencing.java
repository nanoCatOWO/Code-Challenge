import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.util.Collections;

class p760_DNA_Sequencing {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    class DNA {
        TreeSet<String> csCollection;
        boolean thereAreSeqs;
        char[] sa,sb;
        public DNA(){

        }

        public void buildSequences(char[] sa, char[]sb) {
            this.sa = sa; this.sb = sb;
            int sizeCommonSeq, ia, ib;
            String commonSeq, seqCollection;
            csCollection = new TreeSet<String>();
            csCollection.add("");
            for(ia = 0; ia < sa.length; ia++) {
                for(ib = 0; ib < sb.length; ib++) {
                    sizeCommonSeq = 0;
                    commonSeq = "";
                    while(sizeCommonSeq+ia < sa.length && sizeCommonSeq+ib < sb.length && sa[ia+sizeCommonSeq] == sb[ib+sizeCommonSeq]) {
                        commonSeq += sa[ia+sizeCommonSeq];
                        sizeCommonSeq++;
                    }
                    // out.println(commonSeq);
                    seqCollection = csCollection.first();
                    if(seqCollection.length() < commonSeq.length()) {
                        csCollection = new TreeSet<String>();
                        csCollection.add(commonSeq);
                        // out.println(csCollection+" ...collection " + commonSeq);
                    } else if(seqCollection.length() == commonSeq.length() && !commonSeq.isEmpty()) {
                        csCollection.add(commonSeq);
                    }
                }
            }
            printSeqs();
        }

        void printSeqs() {
            if(csCollection.first().isEmpty()) {
                out.println("No common sequence.");
            } else {
                // out.println(csCollection+"####");
                for(String seq: csCollection) {
                    out.println(seq);
                }
            }
        }
    }

    public void read() {        
        try {
            String thirdLine;
            int c = 0;
            do {
                if(c > 0) {
                    out.println();
                }
                char[]sa,sb;
                DNA dna = new DNA();
                sa = in.readLine().trim().toCharArray();
                sb = in.readLine().trim().toCharArray();
                if(sa.length < sb.length) {
                    dna.buildSequences(sa, sb);
                } else {
                    dna.buildSequences(sb, sa);
                }
                thirdLine = in.readLine();
                c++;
            }while(thirdLine!=null);
        }catch(Exception e) {
            out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    public static void main(String[]arg) {
        new p760_DNA_Sequencing().read();
    }
}