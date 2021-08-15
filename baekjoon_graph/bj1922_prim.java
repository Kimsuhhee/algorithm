import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1922_prim {
    static int N,M,a,b,c;
    static ArrayList<Edge>[]graph;
    static boolean[] visited;
    static PriorityQueue<Edge>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        pq = new PriorityQueue<>();

        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        while(M-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }

        int sum = 0;
        int cnt = 0; //n-1개의 간선으로 구성
        pq.add(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge temp = pq.poll();

            if(visited[temp.node])continue;

            visited[temp.node] = true;

            sum+=temp.cost;
            for(Edge edge:graph[temp.node]){
                if(!visited[edge.node])
                    pq.add(edge);
            }
            if(++cnt==N)break;

        }
        System.out.println(sum);
    }

    private static class Edge implements Comparable<Edge> {
        int node,cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
}
