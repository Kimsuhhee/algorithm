import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj5719 {
    static int N,M,S,D;
    static int[] dist;
    static boolean[][] isRemoved;
    static boolean[] visited;
    static ArrayList<Integer>preNode[];
    static ArrayList<Node> graph[];
    static PriorityQueue<Node>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        while(true) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());

            if( N == 0 && M == 0 )break;

            stk = new StringTokenizer(br.readLine());
            S = Integer.parseInt(stk.nextToken());
            D = Integer.parseInt(stk.nextToken());

            graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            isRemoved = new boolean[N][N];

            preNode = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                preNode[i] = new ArrayList<>();
            }

            for(int i=0;i<M;i++){
                stk = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(stk.nextToken());
                int v = Integer.parseInt(stk.nextToken());
                int p = Integer.parseInt(stk.nextToken());
                graph[u].add(new Node(v,p));
            }

            dist = new int[N];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[S] = 0;
            pq = new PriorityQueue<>();
            pq.add(new Node(S,0));

            dijkstra();

            //최단경로에 포함된 정점 지우기
            visited = new boolean[N];
            deleteShortestPath(D);

            dist = new int[N];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[S] = 0;
            pq = new PriorityQueue<>();
            pq.add(new Node(S,0));

            almostShortestPath();

            if(dist[D]!=Integer.MAX_VALUE)sb.append(dist[D]+"\n");
            else sb.append(-1+"\n");
        }

        System.out.print(sb);
    }

    private static void almostShortestPath() {
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.node])continue;
            for(Node next : graph[cur.node]){
                if(isRemoved[cur.node][next.node])continue;
                if(dist[next.node] > next.cost + dist[cur.node]){
                    dist[next.node] = next.cost + dist[cur.node];
                    pq.add(new Node(next.node,dist[next.node]));
                }
            }
        }
    }

    private static void deleteShortestPath(int cur) {
        if(visited[cur])return;
        visited[cur] = true;
        for(int next : preNode[cur]){
            isRemoved[next][cur] = true;
            deleteShortestPath(next);
        }
    }

    private static void dijkstra() {
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.node])continue;
            for(Node next : graph[cur.node]){
                if(dist[next.node] > next.cost + dist[cur.node]){
                    dist[next.node] = next.cost + dist[cur.node];
                    preNode[next.node].clear();
                    preNode[next.node].add(cur.node);
                    pq.add(new Node(next.node,dist[next.node]));
                }else if(dist[next.node] == next.cost + dist[cur.node]){
                    preNode[next.node].add(cur.node);
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int node,cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
