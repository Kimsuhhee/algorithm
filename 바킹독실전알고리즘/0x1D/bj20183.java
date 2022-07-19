import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj20183 {
    static int N,M,A,B;
    static long C;
    static ArrayList<Node> graph[];
    static PriorityQueue<Node>pq;
    static long dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        C = Long.parseLong(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            graph[u].add(new Node(v,c));
            graph[v].add(new Node(u,c));
        }

        dist = new long[N+1];

        long st = 1, en = 1000000000;
        long ans = Long.MAX_VALUE;

        while(st <= en){
            long mid = (st + en) / 2;
            if(dijkstra(mid)){
                ans = mid;
                en = mid - 1;
            }else st = mid + 1;
        }
        if(ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void init(){
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[A] = 0;
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)o1.cost - (int)o2.cost;
            }
        });
        pq.add(new Node(A, dist[A]));
    }

    private static boolean dijkstra(long mid) {
        init();
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.node])continue;
            for(Node next : graph[cur.node]){
                if(mid >= next.cost && dist[next.node] > cur.cost + next.cost){
                    dist[next.node] = cur.cost + next.cost;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }

        if(dist[B]>C)return false;
        else return true;
    }

    private static class Node {
        int node;
        long cost;
        public Node(int node, long cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
