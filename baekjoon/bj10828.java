import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj10828 {
    static Stack<Integer> st = new Stack<Integer>();
    static int num,N;
    static String command;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            command = stk.nextToken();

            if(command.equals("push")){
                num=Integer.parseInt(stk.nextToken());
                st.push(num);
            }else if(command.equals("pop")){
                if(st.isEmpty())
                    System.out.println(-1);
                else System.out.println(st.pop());
            }else if(command.equals("size")){
                System.out.println(st.size());
            }else if(command.equals("empty")){
                if(st.isEmpty())
                    System.out.println(1);
                else System.out.println(0);
            }else if(command.equals("top")){
                if(st.isEmpty())
                    System.out.println(-1);
                else System.out.println(st.peek());
            }
        }

        br.close();
    }
}
