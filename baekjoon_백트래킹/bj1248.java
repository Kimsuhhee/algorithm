import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1248 {
    static int N;
    static int[] A;
    static String str;
    static char[][] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        op = new char[N][N];
        int idx = 0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                op[i][j] = str.charAt(idx++);
            }
        }
        A = new int[N];
        permutation(0,N);
    }

    private static void permutation(int n, int N) {
        if(n==N){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                sb.append(A[i]+" ");
            }
            System.out.print(sb);
            System.exit(0);
            return;
        }

        for(int i=-10;i<=10;i++){
            A[n] = i;
            if(possible(n)) {
                permutation(n + 1, N);
            }
        }
    }

    private static boolean possible(int idx) {
        for(int i=0;i<=idx;i++){
            int sum = 0;
            for(int j=i;j<=idx;j++){
                sum += A[j];
                if(sum==0 && op[i][j]!='0')return false;
                if(sum<0 && op[i][j]!='-')return false;
                if(sum>0 && op[i][j]!='+')return false;
            }
        }

        return true;
    }
}
