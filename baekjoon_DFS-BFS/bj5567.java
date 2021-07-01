import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5567 {
    static int n,m,a,b,cnt;
    static int[] visited;
    static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adjList = new LinkedList[n+1];
        visited = new int[n+1];

        for(int i=0;i<=n;i++)
            adjList[i] = new LinkedList<>();
        for(int i=0;i<m;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        bfs(1);
        for(int i=2;i<=n;i++){
            if(visited[i]==2||visited[i]==3)cnt++;
        }
        System.out.println(cnt);
    }

    private static void bfs(int start) {
        Queue<Integer>q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<adjList[cur].size();i++){
                int next = adjList[cur].get(i);
                if(visited[next]==0){
                    visited[next] = visited[cur]+1;
                    q.add(next);
                }
            }
        }
    }

}
