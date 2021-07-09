import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003 {
    static int T,N;
    static int[][] arr = new int[2][43];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp();
        StringBuilder sb = new StringBuilder();
        while(T-- >0){
            N = Integer.parseInt(br.readLine());
            sb.append(arr[0][N]+" "+arr[1][N]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dp() {
        arr[0][0] = 1; arr[1][0] = 0;
        arr[0][1] = 0; arr[1][1] = 1;
        for(int i=2;i<41;i++){
            arr[0][i] = arr[0][i-1] + arr[0][i-2];
            arr[1][i] = arr[1][i-1] + arr[1][i-2];
        }
    }
}
