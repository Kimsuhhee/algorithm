import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1 ;
        while(true){
            String s = br.readLine();
            if(s.charAt(0)=='-')break;
            Stack<Character> st = new Stack<>();
            int fix = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='{') st.push(s.charAt(i)); //'{'여는괄호는 스택에 push
                else{ //'}'닫는 괄호일때
                    if(st.isEmpty()){ //스택이 비어있다면 여는 괄호로 변경하고 스택에 push
                        st.push('{');
                        fix++;
                    }else st.pop(); //스택이 비어있지않다면 스택이 top 과 안정적인 문자열이므로 pop
                }
            }
            fix += st.size()/2; //괄호의 계수가 짝수이므로
            sb.append(count+". ").append(fix).append("\n");
            count++;
        }
        System.out.println(sb);
    }
}
