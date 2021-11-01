import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16953 {
    static int A,B;
    static Queue<Info>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        q = new LinkedList<>();
        q.add(new Info(A,1));

        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.num==B){
                System.out.println(cur.cnt);
                System.exit(0);
            }
            if(cur.num*2<=1000000000){
                q.add(new Info(cur.num*2,cur.cnt+1));
            }
            String s = String.valueOf(cur.num);
            s = s + "1";
            long num = Long.parseLong(s);
            if(num<=1000000000){
                q.add(new Info(num,cur.cnt+1));
            }
        }
        System.out.println(-1);
    }

    private static class Info {
        long num,cnt;

        public Info(long num, long cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
