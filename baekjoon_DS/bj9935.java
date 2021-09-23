import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        Stack<Character>st = new Stack<>();
        for(int i=0;i<s.length();i++){
            st.add(s.charAt(i));
            if(st.size()>=bomb.length()){
                boolean flag = true;
                for(int j=0;j<bomb.length();j++){
                    char c1 = st.get(st.size()-bomb.length()+j);
                    char c2 = bomb.charAt(j);
                    if(c1!=c2){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0;j<bomb.length();j++) st.pop();
                }
            }
        }
        if(st.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.reverse());
    }
}
