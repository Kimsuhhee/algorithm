import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj15787 {
    static int N,M;
    static int[] train;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        train = new int[N+1];
        while (M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(stk.nextToken());
            int idx = Integer.parseInt(stk.nextToken());
            if(c==1||c==2) {
                int seat = Integer.parseInt(stk.nextToken());
                if(c==1){
                    train[idx] |= (1<<seat);
                }
                if(c==2){
                    train[idx] &= ~(1<<seat);
                }
            }else{
                if(c==3){
                    train[idx] = train[idx] << 1;
                    train[idx] = train[idx] & (1<<21)-1;
                }
                if(c==4){
                    train[idx] = train[idx] >> 1;
                    train[idx] = train[idx] & ~1;
                }
            }
        }
        HashSet<Integer>set = new HashSet<>();
        for(int i=1;i<=N;i++){
            set.add(train[i]);
        }
        System.out.println(set.size());
    }
}
