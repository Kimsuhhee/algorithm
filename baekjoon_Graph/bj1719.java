import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1719 {
    static int n,m;
    static ArrayList<Node>nodes[];
    static PriorityQueue<Node>pq;
    static int[] dist,path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        nodes = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            nodes[a].add(new Node(b,c));
            nodes[b].add(new Node(a,c));
        }

        StringBuilder sb = new StringBuilder();

        //1~n번 노드까지 dijkstra수행
        for(int start=1;start<=n;start++) {
            dist = new int[n + 1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            path = new int[n + 1];
            pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });
            dist[start] = 0;
            pq.add(new Node(start,dist[start]));

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(cur.cost != dist[cur.node])continue;
                for(Node next : nodes[cur.node]){
                    if(dist[next.node] > cur.cost + next.cost){
                        dist[next.node] = cur.cost + next.cost;
                        pq.add(new Node(next.node,dist[next.node]));
                        //현재 노드의 부모노드 저장
                        path[next.node] = cur.node;
                    }
                }
            }

            //부모노드 정보를 기록한 path배열을 사용해 경로탐색
            for(int x=1;x<=n;x++){
                if(path[x] == 0) {
                    sb.append("- ");
                    continue;
                }
                if(path[x] == start) {
                    sb.append(x+" ");
                }
                else{
                    int idx = x;
                    while(path[idx]!=start){
                        idx = path[idx];
                    }
                    sb.append(idx+" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    private static class Node {
        int node,cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
