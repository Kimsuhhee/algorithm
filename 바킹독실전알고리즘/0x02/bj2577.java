import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = Integer.toString(A*B*C);
        String[] tmp = result.split("");
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10];

        for(int i=0;i<tmp.length;i++){
            cnt[Integer.parseInt(tmp[i])]++;
        }
        for(int i=0;i<10;i++){
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }
}
