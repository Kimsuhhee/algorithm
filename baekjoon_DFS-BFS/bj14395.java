import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14395 {
    static int s,t;
    static HashSet<Long>set;
    static Queue<Exp>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        //s와 t가 같은 경우 => 0
        if(s==t) {
            System.out.println(0);
            System.exit(0);
        }

        set = new HashSet<>();
        set.add((long)s);

        q = new LinkedList<>();
        q.add(new Exp(s,""));

        while(!q.isEmpty()){
            Exp cur = q.poll();

            long num = cur.number;
            String exp = cur.exp;

            //s를 t로 바꿀 수 있는 경우 해당하는 연산 출력
            if(num==t){
                System.out.println(exp);
                System.exit(0);
            }

            if(num*num<=1000000000 && !set.contains(num*num)){
                q.add(new Exp(num*num,exp+"*"));
                set.add(num*num);
            }
            if(num+num<=1000000000 && !set.contains(num+num)){
                q.add(new Exp(num+num,exp+"+"));
                set.add(num+num);
            }
            if(num-num>=1 && num-num<=1000000000 && !set.contains(num-num)){
                q.add(new Exp(num-num,exp+"-"));
                set.add(num-num);
            }
            if(num!=0 && num/num<=1000000000 && !set.contains(num/num)){
                q.add(new Exp(num/num,exp+"/"));
                set.add(num/num);
            }
        }

        //s를 t로 바꿀 수 없는 경우 => -1
        System.out.println(-1);

    }

    private static class Exp {
        long number;
        String exp;

        public Exp(long number, String exp) {
            this.number = number;
            this.exp = exp;
        }
    }
}
