import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2661 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        permutation("", 0, N);
    }

    private static void permutation(String s, int n, int N) {
        if(n==N){
            System.out.println(s);
            System.exit(0);
            return;
        }
        for(int i=1;i<=3;i++){
            if(possible(s+i)) {
                permutation(s+i, n + 1, N);
            }
        }
    }

    private static boolean possible(String s) {
        for(int len=1;len<=s.length()/2;len++){
            if(s.substring(s.length()-len,s.length()).equals(s.substring(s.length()-len-len,s.length()-len))){
                return false;
            }
        }
        return true;
    }
}
