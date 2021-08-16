import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11399 {
    static int N,p;
    static int[] times;
    static PriorityQueue<Time>pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            pq.add(new Time(i,Integer.parseInt(stk.nextToken())));
        }
        int idx = 1;
        times = new int[N+1];
        while(!pq.isEmpty()){
            Time temp = pq.poll();
            times[idx++] = temp.time;
        }

        int ans = 0;
        int sum;
        for(int i=1;i<=N;i++){
            sum = 0;
            for(int j=1;j<=i;j++){
                sum += times[j];
            }
            ans+=sum;
        }
        System.out.println(ans);
    }

    private static class Time implements Comparable<Time>{
        int num,time;

        public Time(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Time o) {
            return this.time-o.time;
        }
    }
}
