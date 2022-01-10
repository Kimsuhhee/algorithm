import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj13418 {
    static int N,M;
    static PriorityQueue<Info>min,max;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        min = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.cost - o2.cost;
            }
        });
        max = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.cost - o1.cost;
            }
        });
        for(int i=0;i<M+1;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken()); //0->1, 1->0
            if(c==0){
                min.add(new Info(a,b,1));
                max.add(new Info(a,b,1));
            }else if(c==1){
                min.add(new Info(a,b,0));
                max.add(new Info(a,b,0));
            }
        }

        //오르막길 개수
        int minCost = 0, maxCost = 0;

        //최선의 경로
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        while(!min.isEmpty()){
            Info cur = min.poll();
            int u = cur.u;
            int v = cur.v;

            int pu = find(u);
            int pv = find(v);
            if(pu==pv)continue;
            union(u,v);
            minCost+=cur.cost;
        }

        //최악의 경로
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        while(!max.isEmpty()){
            Info cur = max.poll();
            int u = cur.u;
            int v = cur.v;

            int pu = find(u);
            int pv = find(v);
            if(pu==pv)continue;
            union(u,v);
            maxCost+=cur.cost;
        }
        //피로도 = 오르막 개수 * 오르막 개수
        System.out.println(maxCost*maxCost - minCost*minCost);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u!=v){
            parent[u] = v;
        }else return;
    }

    private static int find(int u) {
        if(u==parent[u])return u;
        return parent[u] = find(parent[u]);
    }

    private static class Info {
        int u,v,cost;

        public Info(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
