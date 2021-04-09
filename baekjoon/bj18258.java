import java.io.*;
import java.util.*;

public class bj18258 {
    static Deque<Integer> dq = new ArrayDeque<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String command; int num;

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            command = stk.nextToken();

            if(command.equals("push")){
                num=Integer.parseInt(stk.nextToken());
                dq.offer(num);
            }else if(command.equals("pop")){
                if(dq.isEmpty())
                    sb.append(-1).append('\n');
                else sb.append(dq.poll()).append('\n');
            }else if(command.equals("size")){
                sb.append(dq.size()).append('\n');
            }else if(command.equals("empty")){
                if(dq.isEmpty())
                    sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }else if(command.equals("front")){
                if(dq.isEmpty())
                    sb.append(-1).append('\n');
                else sb.append(dq.peekFirst()).append('\n');
            }else if(command.equals("back")){
                if(dq.isEmpty())
                    sb.append(-1).append('\n');
                else sb.append(dq.peekLast()).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}
