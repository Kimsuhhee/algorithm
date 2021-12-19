import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11438 {
    static int N,M;
    static int[] depth;
    static int[][]p;
    static ArrayList<Integer>[]tree;
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

        depth = new int[N+1];
        p = new int[N+1][18];

        dfs(1,1);
        dp();

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append(lca(a,b)+"\n");
        }
        System.out.print(sb);
    }

    //조상 노드 정보 입력
    private static void dp() {
        for(int i=1;i<=17;i++){
            for(int j=1;j<=N;j++){
                p[j][i] = p[p[j][i-1]][i-1];
            }
        }
    }

    private static void dfs(int cur, int d) {
        depth[cur] = d++;
        for(int next : tree[cur]){
            if(depth[next]==0){
                p[next][0] = cur; //부모노드 정보
                dfs(next,d);
            }
        }
    }

    private static int lca(int a, int b) {
        if(depth[a]>depth[b]) {
            while(depth[a]!=depth[b]){
                for(int i=17;i>=0;i--){
                    if(depth[a]-depth[b] >= (1<<i)){
                        a = p[a][i];
                    }
                }
            }
        }else if(depth[a]<depth[b]){
            while(depth[a]!=depth[b]){
                for(int i=17;i>=0;i--){
                    if(depth[b]-depth[a] >= (1<<i)){
                        b = p[b][i];
                    }
                }
            }
        }

        if(a==b) return a;

        for(int i=17;i>=0;i--){
            if(p[a][i]!=p[b][i]){
                a = p[a][i];
                b = p[b][i];
            }
        }

        return p[a][0];
    }

}

