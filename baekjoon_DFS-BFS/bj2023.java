import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("",0);
        System.out.println(sb);
    }

    private static void dfs(String s, int n) {
        if(n==N){
            int num = Integer.parseInt(s);
            if(!isPrime(num))sb.append(s).append("\n");
            return;
        }
        if(n>0){
            int num = Integer.parseInt(s);
            if(isPrime(num))return;
        }
        for(int i=0;i<10;i++){
            dfs(s+i,n+1);
        }

    }

    private static boolean isPrime(int num) {
        if(num==0||num==1)return true;
        for(int i=2;i<num;i++){
            if(num%i==0)return true;
        }
        return false;
    }
}
