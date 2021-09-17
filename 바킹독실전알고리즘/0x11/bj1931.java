import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Info>pq = new PriorityQueue<Info>();
        StringTokenizer stk;
        while(N-- >0){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            pq.add(new Info(s,e));
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            int st = cur.start;
            int et = cur.end;
            cnt++;
            while(!pq.isEmpty() && et>pq.peek().start){
                pq.poll();
            }
        }
        System.out.println(cnt);
    }

    private static class Info implements Comparable<Info>{
        int start,end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if(this.end==o.end){
                return this.start-o.start;
            }
            return this.end - o.end;
        }
    }
}
