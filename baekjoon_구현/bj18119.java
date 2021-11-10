import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18119 {
    static int N,M;
    static int[]words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        words = new int[N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                words[i] |= 1<<(s.charAt(j)-'a');
            }
        }
        int S = (1<<27)-1;
        while(M-- >0){
            stk = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(stk.nextToken());
            char x = stk.nextToken().charAt(0);
            if(o==1){
                 S &= ~(1<<(x-'a'));
            }else if(o==2){
                S |= (1<<(x-'a'));
            }
            int cnt = 0;
            for(int bit:words){
                if((S&bit) == bit)cnt++;
            }
            System.out.println(cnt);
        }
    }
}
