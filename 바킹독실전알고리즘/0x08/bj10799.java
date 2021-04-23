import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String stick = br.readLine();
        Stack<Character> st = new Stack();
        int stickCnt = 0;

        for(int i=0;i<stick.length();i++){
            if(stick.charAt(i)=='('){
                st.push(stick.charAt(i));

            }else if(stick.charAt(i)==')'){
                st.pop();
                if(stick.charAt(i-1)=='('){ //직전에 여는괄호가 있었다면 레이저임
                    stickCnt += st.size();
                }else
                    stickCnt+=1;
            }
        }
        System.out.println(stickCnt);
    }
}
