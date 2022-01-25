import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1854 {
    static int n,m,k;
    static PriorityQueue<Integer>dist[];
    static PriorityQueue<Node>pq;
    static ArrayList<Node>graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b,c));
        }

        dist = new PriorityQueue[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1].add(0);
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            if(dist[i].size()<k) sb.append(-1+"\n");
            else sb.append(dist[i].peek()+"\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra() {

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            //현재 비용값이 해당 큐의 최대 값 보다 큰경우 다음 순서로 넘김
            if(cur.cost > dist[cur.node].peek())continue;
            for(Node next : graph[cur.node]){
                //큐 사이즈가 k가 아닌경우 큐에 해당 값 넣기
                if(dist[next.node].size()<k){
                    dist[next.node].add(cur.cost + next.cost);
                    pq.add(new Node(next.node,cur.cost+next.cost));
                }else{
                    //큐 사이즈가 k개이면서 큐에서 가장 큰 값이 현재 값 보다 크면
                    if(dist[next.node].peek() > cur.cost+next.cost){
                        dist[next.node].poll();
                        dist[next.node].add(cur.cost+next.cost);
                        pq.add(new Node(next.node,cur.cost+next.cost));
                    }
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
