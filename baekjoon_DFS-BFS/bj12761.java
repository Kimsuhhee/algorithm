import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12761 {
    static int A,B,N,M;
    static int[] d = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        Arrays.fill(d,-1);
        d[N] = 0;
        Queue<Integer>q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur+1<=100000 && d[cur+1]==-1){
                d[cur+1] = d[cur] + 1;
                q.add(cur+1);
            }
            if(cur-1>=0 && d[cur-1]==-1){
                d[cur-1] = d[cur] + 1;
                q.add(cur-1);
            }
            if(cur+A<=100000 && d[cur+A]==-1){
                d[cur+A] = d[cur] + 1;
                q.add(cur+A);
            }
            if(cur+B<=100000 && d[cur+B]==-1){
                d[cur+B] = d[cur] + 1;
                q.add(cur+B);
            }
            if(cur-A>=0 && d[cur-A]==-1){
                d[cur-A] = d[cur] + 1;
                q.add(cur-A);
            }
            if(cur-B>=0 && d[cur-B]==-1){
                d[cur-B] = d[cur] + 1;
                q.add(cur-B);
            }
            if(cur*A<=100000 && d[cur*A]==-1){
                d[cur*A] = d[cur] + 1;
                q.add(cur*A);
            }
            if(cur*B<=100000 && d[cur*B]==-1){
                d[cur*B] = d[cur] + 1;
                q.add(cur*B);
            }
        }
        System.out.println(d[M]);
    }
}
