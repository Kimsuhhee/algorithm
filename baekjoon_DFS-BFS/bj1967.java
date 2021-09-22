import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1967 {
    static int n,a,b,c,max;
    static boolean[] visited;
    static ArrayList<Node>[]graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for(int i=1;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i,0);
        }

        System.out.println(max);

    }

    private static void dfs(int x,int sum) {
        if(visited[x])return;
        visited[x] = true;
        max = Math.max(sum,max);
        for(int i=0;i<graph[x].size();i++){
            int next = graph[x].get(i).node;
            if(visited[next]) continue;
            dfs(next,sum+graph[x].get(i).cost);
        }
    }

    private static class Node {
        int node,cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
