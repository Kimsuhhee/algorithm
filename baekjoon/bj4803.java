import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj4803 {
    static int n,m,cnt;
    static ArrayList<Integer>[]tree;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        int idx = 0;
        while(true) {
            stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            if(n==0 && m==0)break;
            tree = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int i=0;i<=n;i++) tree[i] = new ArrayList<>();
            for(int i=0;i<m;i++){
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                tree[a].add(b);
                tree[b].add(a);
            }
            cnt = 0;
            for(int i=1;i<=n;i++){
                if(!visited[i]) {
                    if(dfs(i,i)) cnt++;
                }
            }
            ++idx;
            if(cnt==0)sb.append("Case "+idx+": No trees.").append("\n");
            else if(cnt==1)sb.append("Case "+idx+": There is one tree.").append("\n");
            else sb.append("Case "+idx+": A forest of "+cnt+" trees.").append("\n");
        }
        System.out.print(sb);

    }

    private static boolean dfs(int cur,int from) {
        visited[cur] = true;
        for(int i:tree[cur]){
            if(i==from)continue; // 다음에 방문할 노드가 현재노드의 부모라면 방문X
            if(visited[i]) return false;
            if(!dfs(i,cur)) return false;
        }
        return true;
    }
}
