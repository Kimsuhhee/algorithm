import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj9012 {
    static Stack<Character> st;
    static int T;

    private static boolean isVPS(String ps) {
        st = new Stack<Character>();
        char[] tmp = ps.toCharArray();
        for(char c : tmp){
            if(c=='(')st.push(c);
            else if(c==')'){
                if(!st.isEmpty() && st.peek()=='(')st.pop();
                else return false;
            }
        }
        if(st.size()!=0)
            return false;

        else return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String ps = br.readLine();
            if(isVPS(ps)) System.out.println("YES");
            else System.out.println("NO");
        }

        br.close();
    }

}
