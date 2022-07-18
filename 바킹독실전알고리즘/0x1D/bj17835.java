import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj17835 {
    static int N,M,K;
    static long maxD, minNum;
    static long[] dist;
    static ArrayList<Node>graph[];
    static PriorityQueue<Node>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());
            //단방향, 간선방향 거꾸로연결
            graph[V].add(new Node(U,C));
        }

        stk = new StringTokenizer(br.readLine());

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        pq = new PriorityQueue<>();

        for(int i=0;i<K;i++){
            int room = Integer.parseInt(stk.nextToken());
            dist[room] = 0;
            pq.add(new Node(room,dist[room]));
        }

        dijkstra();
        minNum = Long.MAX_VALUE;
        maxD = 0;
        for(int i=1;i<=N;i++){
            if(maxD < dist[i]){
                maxD = dist[i];
                minNum = i;
            }
        }
        System.out.println(minNum);
        System.out.println(maxD);
    }

    private static void dijkstra() {
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.cost > dist[node.end])continue;
            for(Node next : graph[node.end]){
                if(dist[next.end] > node.cost + next.cost){
                    dist[next.end] = node.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

    }

    private static class Node implements Comparable<Node>{
        int end;
        long cost;

        public Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int)this.cost - (int)o.cost;
        }
    }
}
