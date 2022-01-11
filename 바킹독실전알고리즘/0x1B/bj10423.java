import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj10423 {
    static int N,M,K;
    static int[] parent;
    static PriorityQueue<Info>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        stk = new StringTokenizer(br.readLine());

        //발전소
        for(int i=0;i<K;i++){
            parent[Integer.parseInt(stk.nextToken())] = -1;
        }

        pq = new PriorityQueue<>();

        //u도시와 v도시를 연결하는 케이블정보
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            pq.add(new Info(u,v,w));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            int u = cur.u;
            int v = cur.v;

            int pu = find(u);
            int pv = find(v);

            if(pu==pv)continue;

            if(union(u,v)) {
                answer += cur.cost;
            }
        }
        System.out.println(answer);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u==v)return false;
        else {
            //한쪽만 발전소와 연결되어있는 경우
            if(u==-1){
                parent[v] = u;
            }else if(v==-1){
                parent[u] = v;
            }else if(u!=-1 && v!=-1){  //양쪽모두 발전소에 연결되어있지 않은 경우
                parent[u] = v;
            }
        }
        return true;
    }

    private static int find(int u) {
        if(parent[u]==-1)return -1;
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
