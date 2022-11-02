import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11000 {
    static int N;
    static ClassTime[]timeTable;
    static PriorityQueue<Integer>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        timeTable = new ClassTime[N];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());
            timeTable[i] = new ClassTime(s,t);
        }

        pq = new PriorityQueue<>();
        Arrays.sort(timeTable);

        for(int i=0;i<N;i++){
            if(pq.isEmpty()){
                pq.add(timeTable[i].t);
            }else{
                //pq 첫번째 값이랑 timeTable값 비교
                if(pq.peek() > timeTable[i].s){
                    //종료시간 pq에 넣기
                    pq.add(timeTable[i].t);
                }else{
                    pq.poll();
                    pq.add(timeTable[i].t);
                }
            }
        }
        System.out.println(pq.size());
    }

    private static class ClassTime implements Comparable<ClassTime>{
        int s, t;
        public ClassTime(int s, int t){
            this.s = s;
            this.t = t;
        }
        public int compareTo(ClassTime ct){
            return this.s - ct.s;
        }
    }
}
