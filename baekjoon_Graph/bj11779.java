import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11779 {
    static int n,m,s,e;
    static ArrayList<Info>[]cities;
    static int[]p,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //도시의 개수
        m = Integer.parseInt(br.readLine()); //버스의 개수
        cities = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            cities[i] = new ArrayList<>();
        }
        StringTokenizer stk;
        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            cities[a].add(new Info(b,c));
        }
        stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        e = Integer.parseInt(stk.nextToken());

        //거쳐온 노드기록
        p = new int[n+1];
        Arrays.fill(p,-1);
        p[s] = 0;

        PriorityQueue<Info>pq = new PriorityQueue<>();
        d = new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[s] = 0;
        pq.add(new Info(s,d[s]));

        while(!pq.isEmpty()){
            Info cur = pq.poll();
            
            //현재 비용이 기록된 비용보다 큰 경우는 순서 넘기기
            if(cur.cost>d[cur.idx])continue;
            for(Info next:cities[cur.idx]){
                if(d[next.idx]>d[cur.idx]+next.cost){
                    d[next.idx]=d[cur.idx]+next.cost;
                    pq.add(new Info(next.idx,d[next.idx]));
                    p[next.idx] = cur.idx;
                }
            }
        }

        int end = e;
        Stack<Integer>st = new Stack<>();

        //시작 노드로 거슬러 올라가면서 기록
        while(end!=0){
            st.add(end);
            end = p[end];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[e]+"\n");
        sb.append(st.size()+"\n");
        while(!st.isEmpty()){
            sb.append(st.pop()+" ");
        }
        System.out.println(sb);
    }

    private static class Info implements Comparable<Info>{
        int idx,cost;

        public Info(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return cost - o.cost;
        }
    }
}
