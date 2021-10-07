import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1916 {
    static int N,M;
    static int start,end;
    static boolean[] visited;
    static PriorityQueue<Node> pq;
    static Node[]d;
    static ArrayList<Node>[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            bus[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            bus[a].add(new Node(b,c));
        }
        stk = new StringTokenizer(br.readLine());
        start = Integer.parseInt(stk.nextToken());
        end = Integer.parseInt(stk.nextToken());

        visited = new boolean[N+1];
        pq = new PriorityQueue<>();
        d = new Node[N+1];
        for(int i=1;i<=N;i++){
            if(i==start) d[i] = new Node(i,0);
            else d[i] = new Node(i,Integer.MAX_VALUE);
            pq.add(d[i]);
        }
        dijkstra();
        System.out.println(d[end].cost);

    }

    private static void dijkstra() {
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost==Integer.MAX_VALUE) continue;
            for(Node next:bus[cur.node]){
                if(visited[next.node])continue;
                if(d[next.node].cost>d[cur.node].cost+next.cost){
                    d[next.node].cost = d[cur.node].cost+next.cost;
                    pq.remove(d[next.node]);
                    pq.add(d[next.node]);
                }
            }
            visited[cur.node] = true;
        }
    }

    private static class Node implements Comparable<Node> {
        int node,cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
}
