import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1240 {
    static int N,M,answer;
    static ArrayList<Node>[]tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        tree = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            tree[a].add(new Node(b,c));
            tree[b].add(new Node(a,c));
        }

        StringBuilder sb = new StringBuilder();
        visited = new boolean[N+1];
        while(M-- >0){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            answer = 0;
            dfs(start,end,0);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }

    private static void dfs(int start, int end, int sum) {
        if(start==end){
            answer = sum;
            return;
        }
        visited[start] = true;
        for(Node node:tree[start]){
            if(!visited[node.node]){
                visited[node.node] = true;
                dfs(node.node,end,sum+node.dist);
                visited[node.node] = false;
            }
        }
        visited[start] = false;
    }

    private static class Node {
        int node,dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
