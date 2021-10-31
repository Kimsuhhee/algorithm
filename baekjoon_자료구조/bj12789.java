import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj12789 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer>q = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            q.add(Integer.parseInt(stk.nextToken()));
        }
        Stack<Integer> s = new Stack<>();
        int order = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==order){
                order++;
            }else if(cur!=order){
                s.add(cur);
            }
            while(!s.isEmpty() && s.peek()==order){
                s.pop();
                order++;
            }
        }
        if(s.isEmpty()) System.out.println("Nice");
        else {
            boolean flag = true;
            while(!s.isEmpty()){
                int cur = s.pop();
                if(cur==order)order++;
                else {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("Nice");
            else System.out.println("Sad");
        }
    }
}
