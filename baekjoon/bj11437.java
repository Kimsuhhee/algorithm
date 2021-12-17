import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11437 {
    static int N,M;
    static int[] depth,p;
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
        p = new int[N+1];
        dfs(1,1); //모든 노드 각각 깊이와 부모노드 정보 계산

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

    private static void dfs(int cur, int d) {
        depth[cur] = d++;
        for(int next : tree[cur]){
            if(depth[next]==0){
                p[next] = cur;
                dfs(next,d);
            }
        }
    }

    private static int lca(int a, int b) {
        //두 노드의 깊이가 같을때 까지 거슬러 올라감	
        if(depth[a]>depth[b]) {
            while(depth[a]!=depth[b]){
                a = p[a];
            }
        }else if(depth[a]<depth[b]){
            while(depth[a]!=depth[b]){
                b = p[b];
            }
        }

        //두 노드의 부모노드가 같을때 까지 거슬러 올라감
        while(a!=b){
            a = p[a];
            b = p[b];
        }
        return a;
    }

}
