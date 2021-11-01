import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2346 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        Deque<Balloon>dq = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            dq.add(new Balloon(i+1,Integer.parseInt(stk.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            Balloon cur = dq.poll();
            sb.append(cur.idx+" ");
            if(dq.isEmpty())break;
            if(cur.number>=1){
                for(int i=0;i<cur.number-1;i++){
                    Balloon temp = dq.poll();
                    dq.addLast(temp);
                }
            }else{
                for(int i=0;i<Math.abs(cur.number);i++){
                    Balloon temp = dq.pollLast();
                    dq.addFirst(temp);
                }
            }
        }
        System.out.println(sb);
    }

    private static class Balloon {
        int idx,number;

        public Balloon(int idx, int number) {
            this.idx = idx;
            this.number = number;
        }
    }
}
