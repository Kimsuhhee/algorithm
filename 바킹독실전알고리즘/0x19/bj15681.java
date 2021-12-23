import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15681 {
    static int N,R,Q;
    static ArrayList<Integer>tree[];
    static int[] p,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        tree = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        p = new int[N+1];
        count = new int[N+1];
        countSubTreeNodes(R);
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            int u = Integer.parseInt(br.readLine());
            sb.append(count[u]+"\n");
        }
        System.out.print(sb);
    }

    private static void countSubTreeNodes(int r) {
        count[r] = 1;
        for(int next : tree[r]){
            if(p[r]==next)continue;
            p[next] = r;
            countSubTreeNodes(next);
            count[r] += count[next];
        }
    }

}
