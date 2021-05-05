import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack();
        long ans = 0;
        for(int i=0;i<N;i++){
            int building = Integer.parseInt(br.readLine());
            while(!st.isEmpty() && st.peek()<=building){ // 스택의 탑 값보다 높은 입력값을 받은경우
                st.pop(); //스택의 탑값을 pop함
            }
            //스택이 비었거나, 스택의 탑값이 입력받은 값보다 큰경우가 되면
            //현재 스택 사이즈를 더하고 스택에 push
            ans+=st.size();
            st.push(building);
        }
        System.out.println(ans);
    }
}
