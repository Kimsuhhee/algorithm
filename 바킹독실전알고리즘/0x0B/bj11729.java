import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11729 {
    static int k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        System.out.println((1<<k)-1); //2^k-1
        func(1,3,k);
        System.out.println(sb);
    }

    private static void func(int a, int b, int n) {
        if(n==1){
            sb.append(a+" "+b).append("\n");
            return;
        }else {
            func(a, 6 - a - b, n - 1); //n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다.
            sb.append(a+" "+b).append("\n"); //1개를 기둥 a에서 b로 옮긴다.
            func(6 - a - b, b, n - 1); //n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.
        }
    }
}
