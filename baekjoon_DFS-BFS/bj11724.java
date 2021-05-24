import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11724 {
    static int N,M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            graph[u-1][v-1] = 1;
            graph[v-1][u-1] = 1;
        }

        int cnt = 0;
        for(int i=0;i<N;i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int s) {
        visited[s] = true;
        for(int i=0;i<N;i++){
            if(graph[s][i]==1 && !visited[i])dfs(i);
        }
    }
}
