import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {
    static int N,K;
    static int[] d = new int[100001];
    static int[] next = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        if(N==K) {
            System.out.println(0);
            return;
        }

        Queue<Integer>q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == K)break;
            next[0] = tmp+1;
            next[1] = tmp-1;
            next[2] = tmp*2;
            for(int i=0;i<3;i++){
                if(next[i]>=0 && next[i]<=100000){
                    if(d[next[i]]==0){
                        d[next[i]] = d[tmp]+1;
                        q.add(next[i]);
                    }
                }
            }
        }
        System.out.println(d[K]);
    }
}
