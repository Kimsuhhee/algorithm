import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2217 {
    static int[] rope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        rope = new int[N];
        for(int i=0;i<N;i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        for(int r:rope) System.out.print(r+" ");
        int len = N;
        int max = -1;
        int[] weights = new int[rope.length];
        for(int i=0;i<N;i++){
            weights[i] = len * rope[i];
            len--;
            max = Math.max(weights[i],max);
        }
        System.out.println(max);
    }
}
