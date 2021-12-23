import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11725 {
    static int N;
    static int[] p;
    static ArrayList<Integer>tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for(int i=1;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        p = new int[N+1];

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            sb.append(p[i]+"\n");
        }

        System.out.print(sb);

    }

    private static void dfs(int x) {
        for(int next:tree[x]){
            if(p[x]==next)continue;
            p[next] = x;
            dfs(next);
        }
    }
}
