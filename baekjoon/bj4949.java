import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4949 {
    static Stack<Character> st;
    static char[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();

            if (s.equals(".")) break;

            if(isBalance(s)) System.out.println("yes");
            else System.out.println("no");
        }

        br.close();
    }

    private static boolean isBalance(String s) {
        st = new Stack<Character>();
        temp = s.toCharArray();

        for(char c : temp){
            if(c == '(' || c == '[') st.push(c);
            else if(c==')'){
                if(!st.isEmpty() && st.peek()=='(') st.pop();
                else return false;
            }else if(c==']'){
                if(!st.isEmpty() && st.peek()=='[') st.pop();
                else return false;
            }
        }
        if(st.isEmpty())return true;
        else return false;
    }

}
