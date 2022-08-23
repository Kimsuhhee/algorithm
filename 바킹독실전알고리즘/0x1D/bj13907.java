import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj13907 {
    static int N,M,K,S,D;
    static ArrayList<Node>graph[];
    static PriorityQueue<Node>pq;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

        stk = new StringTokenizer(br.readLine());
        S = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b,w,0));
            graph[b].add(new Node(a,w,0));
        }

        dist = new int[N+1][N+1];
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        for(int i=0;i<=N;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[S][0] = 0;
        pq.add(new Node(S,0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.depth>=N)continue;
            if(dist[node.node][node.depth] != node.cost)continue;
            for(Node next : graph[node.node]){
                if(dist[next.node][node.depth+1] > node.cost + next.cost){
                    dist[next.node][node.depth+1] = node.cost + next.cost;
                    pq.add(new Node(next.node,dist[next.node][node.depth+1],node.depth+1));
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            answer = Math.min(answer,dist[D][i]);
        }
        System.out.println(answer);

        for(int i=0;i<K;i++){
            int p = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            for(int n=1;n<N;n++){
                if(dist[D][n]==Integer.MAX_VALUE)continue;
                dist[D][n] = dist[D][n] + (p*n);
                answer = Math.min(answer,dist[D][n]);
            }
            System.out.println(answer);
        }
    }

    private static class Node {
        int node,cost,depth;

        public Node(int node, int cost, int depth) {
            this.node = node;
            this.cost = cost;
            this.depth = depth;
        }
    }
}
