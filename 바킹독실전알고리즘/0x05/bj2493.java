import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj2493 {

    private static class Top {
        int index;
        int num;

        public Top(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Top> st = new Stack();
        String top = br.readLine();
        String[] tops = top.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++){
            while(!st.isEmpty()){
                //스택이 비어있지 않은동안 스택의 탑값과 tops[i]값 비교
                
                if(Integer.parseInt(tops[i]) < st.peek().num){
                    //스택의 탑값이 tops[i]보다 크면 스택의 탑값 인덱스를 출력하고 while문 탈출
                    sb.append(st.peek().index).append(" ");break;
                }
                //스택의 탑값이 tops[i]보다 작으면 pop()
                st.pop();
            }
            if(st.isEmpty())sb.append(0).append(" ");
            //스택이 비어있다면
            //이전 탑중에서 현재의 값보다 높은 값이 없다고 생각하고 0을 출력

            //스택에 tops[i]를 push
            st.push(new Top(i+1,Integer.parseInt(tops[i])));
        }
        System.out.println(sb);
    }

}
