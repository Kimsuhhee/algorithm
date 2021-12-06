import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1929 {
    static int M,N;
    static int[] primeSieve;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        primeSieve = new int[1000001];
        for(int i=2;i<=1000000;i++){
            primeSieve[i] = i;
        }
        for(int i=2;i<=1000000;i++){
            for(int j=i+i;j<=1000000;j+=i){
                primeSieve[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=M;i<=N;i++){
            if(primeSieve[i]!=0) sb.append(i+"\n");
        }
        System.out.print(sb);
    }
}
