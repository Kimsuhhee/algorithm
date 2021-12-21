import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj15903 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        PriorityQueue<Long>pq = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            long next = Long.parseLong(stk.nextToken());
            pq.add(next);
        }
        while(m-- > 0){
            long min1 = pq.poll();
            long min2 = pq.poll();
            for(int i=0;i<2;i++) {
                pq.add(min1+min2);
            }
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
