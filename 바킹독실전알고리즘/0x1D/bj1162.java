import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1162 {
    static int N,M,K;
    static ArrayList<Node>graph[];
    static PriorityQueue<Node>pq;
    static long[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++)graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            graph[u].add(new Node(v,cost,0));
            graph[v].add(new Node(u,cost,0));
        }
        dist = new long[N+1][K+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(dist[i],Long.MAX_VALUE);
        }

        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o1.cost - o2.cost);
            }
        });

        dist[1][0] = 0;
        pq.add(new Node(1,0,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(dist[node.node][node.cnt] != node.cost)continue;
            for(Node next : graph[node.node]){
                //다음에 지나갈 도로를 포장하지 않은 경우
                if(dist[next.node][node.cnt] > node.cost + next.cost){
                    dist[next.node][node.cnt] = node.cost + next.cost;
                    pq.add(new Node(next.node,dist[next.node][node.cnt],node.cnt));
                }
                //다음에 지나갈 도로를 포장하는 경우
                if(node.cnt < K && dist[next.node][node.cnt+1] > node.cost){
                    dist[next.node][node.cnt+1] = node.cost;
                    pq.add(new Node(next.node,dist[next.node][node.cnt+1],node.cnt+1));
                }
            }

        }

        long answer = Long.MAX_VALUE;
        for(int i=0;i<=K;i++){
            answer = Math.min(answer,dist[N][i]);
        }
        System.out.println(answer);

    }

    private static class Node {
        int node,cnt;
        long cost;

        public Node(int node, long cost, int cnt) {
            this.node = node;
            this.cost = cost;
            this.cnt = cnt;
        }
    }
}
