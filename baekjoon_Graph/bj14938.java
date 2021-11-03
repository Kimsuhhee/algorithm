import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj14938 {
    static int n,m,r;
    static int[] items,d;
    static ArrayList<Info>area[];
    static PriorityQueue<Info>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());

        items = new int[n+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            items[i] = Integer.parseInt(stk.nextToken());
        }

        area = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            area[i] = new ArrayList<>();
        }
        while(r-- > 0){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int l = Integer.parseInt(stk.nextToken());
            area[a].add(new Info(b,l));
            area[b].add(new Info(a,l));
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            d = new int[n+1];
            Arrays.fill(d,Integer.MAX_VALUE);
            d[i] = 0;
            pq = new PriorityQueue<>();
            pq.add(new Info(i,d[i]));
            max = Math.max(max,dijkstra(i));
        }
        System.out.println(max);
    }

    private static int dijkstra(int idx) {
        while(!pq.isEmpty()){
            Info info = pq.poll();
            for(Info next:area[info.num]){
                if(d[next.num]>d[info.num]+next.cost){
                    d[next.num]=d[info.num]+next.cost;
                    pq.add(new Info(next.num,d[next.num]));
                }
            }
        }
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(d[i]<=m) {
                sum += items[i];
            }
        }
        return sum;
    }

    private static class Info implements Comparable<Info> {
        int num,cost;

        public Info(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return this.cost-o.cost;
        }
    }
}
