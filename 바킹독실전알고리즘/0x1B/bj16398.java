import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj16398 {
    static int N;
    static PriorityQueue<Info>pq;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        pq = new PriorityQueue<>();

        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int k = Integer.parseInt(stk.nextToken());
                if(i==j)continue;
                pq.add(new Info(i,j,k));
            }
        }

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        long answer = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();

            int u = cur.u;
            int v = cur.v;

            int pu = find(u);
            int pv = find(v);

            if(pu==pv)continue;
            union(u,v);
            answer += cur.cost;
        }
        System.out.println(answer);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u!=v){
            parent[v] = u;
        }
        else return;
    }

    private static int find(int u) {
        if(u==parent[u])return u;
        return parent[u] = find(parent[u]);
    }

    private static class Info implements Comparable<Info>{
        int u,v,cost;

        public Info(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }
}
