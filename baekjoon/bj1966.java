import java.io.*;
import java.util.*;

public class bj1966 {

    private static class Qinfo {
        int order;
        int cost;

        public Qinfo(int order, int cost) {
            this.order = order;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.order+","+this.cost;
        }
    }

    static Queue<Qinfo> q = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            int cnt = 0;
            q.clear();
            pq.clear();
            String comm = br.readLine();
            String tmp[]=comm.split(" ");
            int N = Integer.parseInt(tmp[0]);
            int M = Integer.parseInt(tmp[1]);

            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(stk.nextToken());
                q.add(new Qinfo(j,num));
                pq.add(num);
            }

            while(!q.isEmpty()){
                Qinfo qinfo = q.poll();
                if(qinfo.cost==pq.peek()){
                    cnt++;
                    pq.poll();
                    if(qinfo.order==M){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }else{
                    q.add(qinfo);
                }
            }

        }
        System.out.println(sb);
        br.close();
    }

}
