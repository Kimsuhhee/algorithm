import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2312 {
    static int t,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            N = Integer.parseInt(br.readLine());
            for(int i=2;i<1000001;i++){
                if(i>N)break;
                int cnt = 0;
                while(N%i==0){
                    N /= i;
                    cnt++;
                }
                if(cnt!=0)sb.append(i+" "+cnt+"\n");
            }
        }
        System.out.print(sb);
    }
}
