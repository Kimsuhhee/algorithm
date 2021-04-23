import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            String ps = br.readLine();
            boolean flag = true;
            Stack<Character>st = new Stack<>();
            for(int i=0;i<ps.length();i++){
                char c = ps.charAt(i);
                if(c=='('){
                    st.push(c);
                }else{
                    if(!st.isEmpty() && st.peek()=='(')st.pop();
                    else{
                        flag =false;
                        break;
                    }
                }
            }
            if(!st.isEmpty()) flag = false;
            if(!flag)sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        System.out.println(sb);
    }
}
