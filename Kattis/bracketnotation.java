import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 5,29:11,17:17,17:23,29:29,29:35,35:
// 5,29:11,17:17,17:23,29:29,29:35,35: 

class bracketnotation {

    Ntree coreTree;
    boolean updateTrees;
    static int C = 2;

    void buildTree(char[]s){
        coreTree = new Ntree(0, 0);
        Stack<Ntree> stack = new Stack<>();
        stack.push(coreTree);
        Ntree tmpNtre,newTree;
        for (char c : s) {
            if(c == '(') {
                tmpNtre = stack.peek();
                newTree = new Ntree(1,1);
                tmpNtre.addChild(newTree);                
                stack.push(newTree);
            } else {
                stack.pop();
            }
        }
    }

    int countDigits(int n) {
        if(n<10) return 1;
        else return countDigits(n/10) + 1;
    }
    

    class Ntree {
        int first,last;
        ArrayList<Ntree> subTrees;
        public Ntree() {
            first = last = 1;
            subTrees = new ArrayList<>();
        }

        public Ntree(int first, int last) {
            this.first = first;
            this.last = last;
            subTrees = new ArrayList<>();
        }

        public void addChild(Ntree ntree) {
            subTrees.add(ntree);
        }

        int f() {
            this.last = this.first;
            if(this.isLeaf()) {
                
            } else {
                int newFirst;
                for (Ntree child : subTrees) {
                    // System.out.print(this.first+"\n");
                    newFirst = this.last + countDigits(child.first) + countDigits(child.last) + C;
                    // System.out.println(" ..first ..."+child.first+"...last...."+child.last);
                    // System.out.println("newFirst..."+newFirst +"##################\n");
                    if(newFirst != child.first) {
                        updateTrees = true;
                    }
                    child.first = newFirst;
                    this.last = child.f();
                }
            }
            return this.last;
        }

        boolean isLeaf() {
            return subTrees.isEmpty();
        }

        @Override
        public String toString() {
            // String s = "["+this.first+" ";
            // for (Ntree child : subTrees) {
            //     s += child.toString() + " ";
            // }
            // return s + this.last+"]";
            String s = "";
            for (Ntree child : subTrees) {
                s += child.first + "," + child.last + ":" + child.toString();
            }
            return s;
        }
    }    

    public void adjustCoreTree() {
        do{
            updateTrees = false;            
            coreTree.last = 0;
            coreTree.f();
        }while(updateTrees);
    }

    public static void main(String[]arg) {
        new bracketnotation().solve();
    }   

    public void solve() {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        buildTree(s);
        adjustCoreTree();
        System.out.println(coreTree);
    }
}
