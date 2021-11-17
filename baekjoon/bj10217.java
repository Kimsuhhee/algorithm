import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj10217 {
    static int T,N,M,K;
    static ArrayList<Info>[]airport;
    static int[][] d;
    static PriorityQueue<Info>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken()); //공항의 수
            M = Integer.parseInt(stk.nextToken()); //지원 비용
            K = Integer.parseInt(stk.nextToken()); //티켓정보의 수

            airport = new ArrayList[N+1];
            for(int i=0;i<=N;i++){
                airport[i] = new ArrayList<>();
            }

            for(int i=0;i<K;i++){
                stk = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(stk.nextToken()); //출발
                int v = Integer.parseInt(stk.nextToken()); //도착
                int c = Integer.parseInt(stk.nextToken()); //비용
                int d = Integer.parseInt(stk.nextToken()); //소요시간
                airport[u].add(new Info(v,c,d));
            }
            pq = new PriorityQueue<>();
            d = new int[N+1][M+1]; //d[도착점][비용] = 시간
            for(int i=0;i<=N;i++){
                Arrays.fill(d[i],Integer.MAX_VALUE);
            }
            d[1][0] = 0; //시작 1번 공항, 비용 = 0
            pq.add(new Info(1,0,d[1][0]));

            while(!pq.isEmpty()){
                Info cur = pq.poll();
                if(d[cur.next][cur.cost]<cur.time)continue;
                if(cur.next == N)break;
                for(Info next:airport[cur.next]){
                    if(next.cost + cur.cost>M)continue;
                    if(d[next.next][next.cost + cur.cost]>next.time+d[cur.next][cur.cost]){
                        d[next.next][next.cost + cur.cost] = next.time+d[cur.next][cur.cost];
                        pq.add(new Info(next.next,next.cost + cur.cost,d[next.next][next.cost + cur.cost]));
                    }
                }
            }
            int answer = Integer.MAX_VALUE;
            for(int i=1;i<=M;i++){
                answer = Math.min(answer,d[N][i]);
            }
            if(answer==Integer.MAX_VALUE) sb.append("Poor KCM\n");
            else sb.append(answer+"\n");
        }
        System.out.print(sb);
    }

    private static class Info implements Comparable<Info>{
        int next,cost,time;

        public Info(int next, int cost, int time) {
            this.next = next;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }
}
