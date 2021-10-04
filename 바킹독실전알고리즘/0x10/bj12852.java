import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class bj12852 {
    static int N;
    static int[]d = new int[1000001];
    static int[]p = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arrays.fill(d,-1);
        Queue<Integer>q = new LinkedList<>();
        q.add(N);
        d[N] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur/3 >=1 && cur/3 <=1000000 && cur%3==0){
                if(d[cur/3]==-1 || d[cur/3]>d[cur]+1) {
                    d[cur / 3] = d[cur] + 1;
                    p[cur / 3] = cur;
                    q.add(cur / 3);
                }
            }
            if(cur/2 >=1 && cur/2 <=1000000 && cur%2==0){
                if(d[cur/2]==-1 || d[cur/2]>d[cur]+1) {
                    d[cur / 2] = d[cur] + 1;
                    p[cur / 2] = cur;
                    q.add(cur / 2);
                }
            }
            if(cur-1 >=1 && cur-1 <=1000000) {
                if(d[cur-1]==-1 || d[cur-1]>d[cur]+1) {
                    d[cur - 1] = d[cur] + 1;
                    p[cur - 1] = cur;
                    q.add(cur - 1);
                }
            }
        }
        System.out.println(d[1]);
        Stack<Integer>st = new Stack<>();
        int pre = 1;
        while(true){
            st.add(pre);
            if(pre==N)break;
            pre = p[pre];
        }
        while(!st.isEmpty()) System.out.print(st.pop()+" ");
    }
}
