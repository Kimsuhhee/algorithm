import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character>st = new Stack<>();
        boolean isBalance;

        while(true){
            st.clear();
            isBalance = true;
            String s = br.readLine();

            if(s.equals(".")) break;

            char[] arr = s.toCharArray();
            for(char c : arr){
                if(c=='(' ||c=='['){
                    st.push(c);
                }else if(c==')'){
                    if(st.isEmpty() || st.peek()!='('){
                        isBalance = false;
                        break;
                    }
                    st.pop();
                }else if(c==']'){
                    if(st.isEmpty() || st.peek()!='['){
                    isBalance = false;
                    break;
                    }
                    st.pop();
                }
            }

            if(!st.isEmpty())isBalance = false;

            if(isBalance)sb.append("yes").append("\n");
            else sb.append("no").append("\n");

        }
        System.out.println(sb);
    }
}
